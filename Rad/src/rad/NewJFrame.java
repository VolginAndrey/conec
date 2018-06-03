/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rad;

import java.util.Random;

/**
 *
 * @author volgin
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }
    private static void aswap(char[] pa, int i, int j) {
        char k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }
    public String xORencrypt(String Text, String key) {
        int i, j;
        String result="";
        String Text_Vhods = Text;
        char[] Text_Vhod;
        Text_Vhod = Text_Vhods.toCharArray();
        String Kods = key;
        char[] Kod;
        Kod = Kods.toCharArray();
        for (i = 0; i < Text_Vhods.length(); i++) {
            if (i < Kods.length()) {
                j = i;
            } else {
                j = i % Kods.length();
            }
            if (Text_Vhod[i] == '0') {
                if (Kod[j] == '0') {
                    result = result + '0';
                }
                if (Kod[j] == '1') {
                    result = result + '1';
                }
            }
            if (Text_Vhod[i] == '1') {
                if (Kod[j] == '0') {
                    result = result + '1';
                }
                if (Kod[j] == '1') {
                    result = result + '0';
                }
            }
        }
        return result;

    }
    public String ceaserEncrypt(String textInput,Integer key){
        char[] alfos = new char[34];
        char[] alfnew = new char[34];
        String alfitog = "";
        int k, j = 0;
        char[] text;
        text = textInput.toCharArray();
        int n = textInput.length();
        k = key;
        int al = 33;
        for (char i = 'а'; i <= 'я'; i++) {
            alfos[i - 1071] = i;
            
        }
        for (int i = 0; i <= al; i++) {

            if (i + k < al) {
                alfnew[i] = alfos[i + k];
                
            }
            if (i + k >= al && j < k) {
                alfnew[i] = alfos[j];
                
                j++;
            }

        }
        for (int i = 0; i < n; i++) {

            for (int pos = 0; pos <= al; pos++) {

                if (alfos[pos] == text[i]) {

                    alfitog = alfitog + alfnew[pos];

                }
        
        
            }
        }
        return alfitog;
    }
    public String reshuffleEncrypt(String textInput){
        char[] alfos = new char[34];
        char[] alfNew = new char[34];
        Integer al=33;
        String alfitog = "";
        char[] text;
        text = textInput.toCharArray();
        int n = textInput.length();        
        for (char i = 'а'; i <= 'я'; i++) {
            alfos[i - 1071] = i;
            alfNew[i - 1071] = i;

        }
        String alfInput="";
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < al; i++) {
            int change = i + random.nextInt(al - i);
            aswap(alfNew, i, change);
        }
        for (int i = 0; i < al; i++){
            alfInput=alfInput+alfNew[i];
        }
        jTextField3.setText(alfInput);
        for (int i = 0; i < n; i++) {

            for (int pos = 0; pos <al; pos++) {

                if (alfos[pos] == text[i]) {

                    alfitog = alfitog + alfNew[pos];

                }
            }
 
        }
        
        return alfitog;
    }
    

    private static String arraout(char[] pa, int i) {
        String s = "";

        for (char a : pa) {
            s += a;
        }

        s = s.substring(0, s.length());
        return s;

    }

    private static String prmt(char[] pa, int i, int k, int ik) {
//        if (ik == k) {

//            return;
//        }
        for (int j = i; j < pa.length; j++) {
            ik++;

            aswap(pa, i, j);
            //System.out.println(ik + " " + k);
            if (ik == k) {

                break;
            }
            prmt(pa, i + 1, k, ik);
            aswap(pa, i, j);
        }
        String textInput = arraout(pa, i);
        return textInput;
    }
//    private static char[] splitString(){
//        
//        return elem;
//}


    private static String blockEncrypt(String textInputt,Integer key){
        String textOutPut = "";
        String text;
        String textInput = textInputt;
        Integer k = key;
        Integer nblock = key;
        int raz=textInput.length();
        if (textInput.length()%nblock==0){
            for (int i = 0, j = nblock; i < textInput.length(); i = i + nblock, j = j + nblock) {
                text = textInput.substring(i, j);
                char[] pa = text.toCharArray();
                textOutPut = textOutPut + prmt(pa, 0, k, 0);
            }
        }
        else{
            while(raz>=0){
            raz=raz-nblock;
            }
            for(int i=0;i>raz;i--){
                textInput=textInput+'#';
            }  
            for (int i = 0, j = nblock; i < textInput.length(); i = i + nblock, j = j + nblock) {
                text = textInput.substring(i, j);
                char[] pa = text.toCharArray();
                textOutPut = textOutPut + prmt(pa, 0, k, 0);
            }
        }
        return textOutPut;
    }
    private static String defCeasar(String textInputt, Integer key){
        char[] alfos = new char[34];
        char[] alfnew = new char[34];
        String alfitog = "";
        int k, j = 0;
        String textInput = textInputt;
        char[] text;
        text = textInput.toCharArray();
        int n = textInput.length();
        k = key;
        int al = 33;
        for (char i = 'а'; i <= 'я'; i++) {
            alfos[i - 1071] = i;
            
        }
        for (int i = 0; i <= al; i++) {

            if (i - k > 0) {
                alfnew[i] = alfos[i - k];
                
            }
            if (i - k <= 0 && j < k) {
                alfnew[i] = alfos[j];
                
                j++;
            }

        }
        for (int i = 0; i < n; i++) {

            for (int pos = 0; pos <= al; pos++) {

                if (alfos[pos] == text[i]) {

                    alfitog = alfitog + alfnew[pos];

                }
        
        
            }
        } 
        return alfitog;
    }
    private static String defReshuffle(String textInput,char[] alfInput){
        char[] alfos = new char[34];
        char[] alfNew;
        alfNew = alfInput;
        Integer al=33;
        String alfitog = "";
        char[] text;
        text = textInput.toCharArray();
        int n = textInput.length();        
        for (char i = 'а'; i <= 'я'; i++) {
            alfos[i - 1071] = i;

        }
        for (int i = 0; i < n; i++) {

            for (int pos = 0; pos <al; pos++) {

                if (alfNew[pos] == text[i]) {

                    alfitog = alfitog + alfos[pos];

                }
            }
 
        }
        
        return alfitog;
    }
    private static String defarraout(char[] pa, int i) {
        String s = "";

        for (char a : pa) {
            s += a;
        }

        s = s.substring(0, s.length());
        return s;

    }

    private static String defprmt(char[] pa, int i, int k, int ik) {
//        if (ik == k) {

//            return;
//        }
        for (int j = i; j < pa.length; j++) {
            ik++;

            aswap(pa, j, i);
           // System.out.println(ik + " " + k);
            if (ik == k) {

                break;
            }
            defprmt(pa, i + 1, k, ik);
            aswap(pa, j, i);
        }
        for (int j = i; j < pa.length; j++) {
            ik++;

            aswap(pa, i, j);
           System.out.println(ik + " " + k);
            if (ik == k) {

                break;
            }
            defprmt(pa, i + 1, k, ik);
            aswap(pa, i, j);
        }
        String textInput = defarraout(pa, i);
        return textInput;
    }
//    private static char[] splitString(){
//        
//        return elem;
//}

//    private static String defblockShifr(String textInput, Integer k) {
//        char pa[] = textInput.toCharArray();
//        //Integer k = Integer.valueOf(jTextField2.getText());
//        String block = defprmt(pa, 0, k, 0);
//        return block;
//    }
    private static String defblockEncrypt(String textInputt,Integer key){
        String textOutPut = "";
        String text;
        String textInput = textInputt;
        Integer k = key;
        Integer nblock = key;
        int raz=textInput.length();
        if (textInput.length()%nblock==0){
            for (int i = 0, j = nblock; i < textInput.length(); i = i + nblock, j = j + nblock) {
                text = textInput.substring(i, j);
                char[] pa = text.toCharArray();
                textOutPut = textOutPut + defprmt(pa, 0, k, 0);
            }
        }
        else{
            while(raz>=0){
            raz=raz-nblock;
            }
            for(int i=0;i>raz;i--){
                textInput=textInput+'#';
            }  
            for (int i = 0, j = nblock; i < textInput.length(); i = i + nblock, j = j + nblock) {
                text = textInput.substring(i, j);
                char[] pa = text.toCharArray();
                textOutPut = textOutPut + defprmt(pa, 0, k, 0);
            }
        }
        return textOutPut;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Зашифровать");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Разшифровать");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setName("jDef"); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ceaser Encrypt", "Reshuffle Encrypt", "XOR Encrypt", "Block Encrypt", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Поле ввода, для шифрования");

        jLabel2.setText("Поле ввода, для разшифровки");

        jLabel3.setText("Ключ");

        jTextField3.setText("Генерируемые Алфавиты");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(265, 265, 265)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(149, 149, 149))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ("XOR Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            outText = xORencrypt(jTextField1.getText(),jTextField4.getText());
            jTextField2.setText(outText);
        }
        if ("Ceaser Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            String inputText=jTextField1.getText();
            Integer k=Integer.valueOf(jTextField4.getText());
            outText = ceaserEncrypt(inputText,k);
            jTextField2.setText(outText);
        }
        if ("Reshuffle Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            String inputText=jTextField1.getText();

            outText = reshuffleEncrypt(inputText);
            jTextField2.setText(outText);
        }
        if ("Block Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            String inputText=jTextField1.getText();
            Integer k=Integer.valueOf(jTextField4.getText());
            outText = blockEncrypt(inputText,k);
            jTextField2.setText(outText);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ("Ceaser Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            String inputText=jTextField2.getText();
            Integer k=Integer.valueOf(jTextField4.getText());
            outText = defCeasar(inputText,k);
            jTextField1.setText(outText);
        }       // TODO add your handling code here:
        if ("Reshuffle Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            String inputText=jTextField2.getText();
            //Integer k=Integer.valueOf(jTextField4.getText());
            outText = defReshuffle(inputText,jTextField3.getText().toCharArray() );
            jTextField1.setText(outText);
        }  
        if ("XOR Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            String inputText=jTextField2.getText();
            //Integer k=Integer.valueOf(jTextField4.getText());
            outText = xORencrypt(jTextField1.getText(),jTextField4.getText());
            jTextField1.setText(outText);
        }
        if ("Block Encrypt".equals(jComboBox1.getSelectedItem().toString())) {
            String outText;
            String inputText=jTextField2.getText();
            Integer k=Integer.valueOf(jTextField4.getText());
            outText = defblockEncrypt(inputText,k);
            jTextField1.setText(outText);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NewJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
