/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javauitest;

/**
 *
 * @author P
 */
public class Notes {
    public int posx=0;
    public int posy=0;
    public char type;
    public char octpos;
    
    public Notes(char t,char p){
        type='n';
        octpos='n';
        if(t=='C' && p=='4'){
            posy=134;
        }else if(t=='D' && p=='4'){
            posy=127;
        }else if(t=='E' && p=='4'){
            posy=120;
        }else if(t=='F' && p=='4'){
            posy=114;
        }else if(t=='G' && p=='4'){
            posy=106;
        }else if(t=='A' && p=='4'){
            posy=99;
        }else if(t=='D' && p=='4'){
            posy=92;
        }
    }
    public Notes(char t,char p,int px,int py){
        posx=px;
        posy=py;
        type=t;
        octpos=p;
    }
    
}
