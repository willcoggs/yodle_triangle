package triangle;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author will
 */
public class Triangle {

    public static void main(String[] args) {
        int i=0;
        int tokenCount=0;
        int value=0;
        
        String firstString="";
        String secondString="";
        Scanner s=null;
        
        StringTokenizer st=null;
 
        
        Node[] firstLine=null;
        Node[] secondLine=null;
        
        
        try{
            s=new Scanner(new File("/home/will/Desktop/triangle.txt"));
            
            secondString=s.nextLine();
            st=new StringTokenizer(secondString);
            
            secondLine=new Node[1];
            value=Integer.parseInt(st.nextToken());
            secondLine[0]=new Node(value);
            secondLine[0].setDist(0);
            
            while(s.hasNextLine()){
                firstString=secondString;
                secondString=s.nextLine();
                  
                st=new StringTokenizer(secondString);
         
                tokenCount=st.countTokens();
                firstLine=secondLine;
                secondLine=new Node[tokenCount];
               
                for(i=0; i<tokenCount; i++){
                    value=Integer.parseInt(st.nextToken());
                    secondLine[i]=new Node(value);
                }
                
                for(i=0; i<tokenCount-1; i++){
                    firstLine[i].setLeftChild(secondLine[i]);
                    secondLine[i].setDist(firstLine[i].getDist());
                    
                    firstLine[i].setRightChild(secondLine[i+1]);
                    secondLine[i+1].setDist(firstLine[i].getDist());
                }
            }
            System.out.println(Node.getMax(secondLine));
        }
        catch(Exception e) {
            System.out.println("Exception");
        }
    }
}
