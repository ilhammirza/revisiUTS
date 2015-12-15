/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientuts;

import java.io.BufferedReader;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author Ilham
 */
public class ClientUTS {

public static boolean isNumeric(String str)  
{  
  try  
  {  
    int d = Integer.parseInt(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Masukkan NRP");
         Scanner rd=new Scanner(System.in);
         String p= "Username:"+rd.nextLine()+"\n";
         
        try {
            
            // TODO code application logic here
            Socket socket=new Socket("10.151.43.147",6666);
            //InputStream is = socket.getInputStream();
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream os=socket.getOutputStream();
            
            //os.write("Username:5113100149\n".getBytes());
            os.write(p.getBytes());
            //String mod="mod";
            //Pattern pattern = Pattern.compile([0-9]+|[-+x]+|"+mod);
            int result;
            byte[] buf;
            int len = 0;
            String s,o = null;
           boolean x=true;
            while(x=true) {
                //buf = new byte[200];
                    s = is.readLine();
                    ///String s;
                     String a1= null,a2 = null,a3= null,a4=null;
                    //s = new String(buf).trim();
                System.out.println(s.trim());
                int i=0;
        
                int j=0,k=0,l=0;
                char c;
                if(s.split(" ").length<4){
                   if(s.split(" ").length<2){
                       c =s.charAt(0);
                      if(c=='H'){
                          continue;
                      } 
                      else if(c=='L'){
                          continue;
                       }
                      else{
                          String r="Hash:"+s+"\n";
                          os.write(r.getBytes());
                      }
                      //System.out.println(s);
                     
                   }
                   
                }
                else{
                o=s.split(" ")[3];
                // System.out.println(o);
                    if(o.equalsIgnoreCase("=")){
                        a1=s.split(" ")[0];
                        a2=s.split(" ")[1];
                        a3=s.split(" ")[2];
                        j=Integer.parseInt(a1);
                        l=Integer.parseInt(a3);
                    //System.out.println(a1);
                    String kirim;
                    if(a2.equalsIgnoreCase("x")){
                        k=j*l;
                        kirim="Result:"+k+"\n";
                        System.out.println(kirim);
                        os.write(kirim.getBytes());
                    }
                    else if(a2.equalsIgnoreCase("+")){
                        k=j+l;
                        kirim="Result:"+k+"\n";
                        System.out.println(kirim);
                        os.write(kirim.getBytes());
                    }
                    else if(a2.equalsIgnoreCase("-")){
                        k=j-l;
                        kirim="Result:"+k+"\n";
                        System.out.println(kirim);
                        os.write(kirim.getBytes());
                    }
                    else if(a2.equalsIgnoreCase("mod")){
                        k=j%l;
                        kirim="Result:"+k+"\n";
                        System.out.println(kirim);
                        os.write(kirim.getBytes());
                    }
                    }else continue;
                }
                }
            
        } catch (IOException ex) {
            Logger.getLogger(ClientUTS.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            
            }
            
        
        }
        
    
    

