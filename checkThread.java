public class checkThread implements Runnable{
    Element element1;
    Element element2;
    boolean gotLinks=false;

    checkThread(Element element1, Element element2){
        this.element1=element1;
        this.element2=element2;
    }

    @Override
    public void run() {
        for(int i=0; i<element1.inputAttributes.size(); i++) {
            if (App.checkEntrance(element1.inputAttributes.get(i), element2.outputAttributes)) {
                gotLinks = true;
                synchronized (System.out) {
                    System.out.println(element1.getName() + " input and " + element2.getName() + " output have link:");
                    System.out.println(element1.getName() + " input and " + element2.getName() + " output:");
                }
                if (AttributesList.attributes.get(element1.inputAttributes.get(i).id).type == "int") {
                    synchronized (System.out) {
                        System.out.println(AttributesList.attributes.get(element1.inputAttributes.get(i).id).getName()
                                + ": " + element1.inputAttributes.get(i).value + "\n");
                    }
                } else
                    synchronized (System.out) {
                        System.out.println(AttributesList.attributes.get(element1.inputAttributes.get(i).id).getName()
                                + ": " + AttributesList.attributes.get(element1.inputAttributes.get(i).id).valuesList.get
                                (element1.inputAttributes.get(i).value));
                    }
            }
        }
        if(gotLinks==false)
            synchronized (System.out) {
                System.out.println(element1.getName() + " input and " + element2.getName() + " output have no links");
            }
        Thread.interrupted();
    }
}
