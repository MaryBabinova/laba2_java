import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static boolean checkEntrance(ShortAttribute attribute, ArrayList<ShortAttribute> attributes){
        for(int i=0; i< attributes.size(); i++)
            if (attribute.id==attributes.get(i).id && attribute.value==attributes.get(i).value)
                return true;
        return false;
    }
    public static void checkLinks(Element element1, Element element2){
        new Thread(new checkThread(element1, element2)).start();
        new Thread(new checkThread(element2, element1)).start();
    }

    public static void checkAllElements(ArrayList<Element> elements){
        for(int i=0;i<elements.size()-1;i++)
            for(int j=i+1; j<elements.size(); j++)
                checkLinks(elements.get(i), elements.get(j));
    }
    public static void showElements(ArrayList<Element> elements){
        for(int i=0; i<elements.size(); i++){
            System.out.println(elements.get(i).id+". "+elements.get(i).getName());
            elements.get(i).showAttributes();
        }
    }
    public static void main(String[] args) {
        ArrayList<Element> elements = new ArrayList();
        Scanner in=new Scanner(System.in);
        int answer;
        while(true){
            System.out.println("1. Create new Element\n2. Show elements\n3. Show graph");
            answer=in.nextInt();
            while(answer<1 || answer>3)
                answer=in.nextInt();
            if(answer==1)
                elements.add(new Element(elements.size()));
            if(answer==2)
                showElements(elements);
            if(answer==3){
                if(elements.size()>=2)
                    break;
                else
                    System.out.println("Need more elements");
            }
        }
        checkAllElements(elements);
    }
}
