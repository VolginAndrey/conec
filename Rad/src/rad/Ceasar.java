/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rad;

/**
 *
 * @author KL
 */
public class Ceasar {
    public String encrypt(String textInput,Integer key){
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
}
