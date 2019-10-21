public class Run{

    public static void main(String[] args) throws Exception {

        Controller controller = new Controller();
            controller.run();

//        boolean isContactExists = false;
//
//        File file = new File("contacts.txt");
//        if (file.length() == 0) {
//            System.out.println("File is empty !!! creating new file...");
//            try {
//                file.createNewFile();
//                saveContact(file);
//            } catch (IOException e) {
//                System.out.println("Exception is caught" + e);
//            }
//        } else {
//            try {
//                FileInputStream inputFile = new FileInputStream(file);
//                ObjectInputStream in = new ObjectInputStream(inputFile);
//                saveContact(file);
//                in.close();
//                inputFile.close();
//            } catch (Exception ex) {
//                System.out.println("Exception is caught" + ex);
//            }
//        }
//    }
//
//    private static void saveContact(File file) {
//        try {
//            FileOutputStream outputFile = new FileOutputStream(file);
//            ObjectOutputStream out = new ObjectOutputStream(outputFile);
//            // Method for serialization of object
//            phoneDiary.run();
//            System.out.println("Details successfully saved and has been serialized");
//            out.flush();
//            out.close();
//            outputFile.close();
//        } catch (IOException ex) {
//            System.out.println("IOException is caught");
//        }
//        try {
//            File fi = new File("obj.txt");
//            fi.createNewFile();
//            FileInputStream fis = new FileInputStream(fi);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            phoneDiary = (PhoneDiary) ois.readObject();
//        }
//        catch(Exception e) {
//            PhoneDiary phoneDiary = new PhoneDiary();
//            System.out.println("Exception 1"+e);
//            File f = new File("obj.txt");
//            FileOutputStream fos = new FileOutputStream(f);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            PhoneDiary phoneDiary = (PhoneDiary) ois.readObject();
////            oos.writeObject(new HashMap<String, Object>());
//        }

//        phoneDiary.run();
//
//        File f = new File("obj.txt");
//        fi.createNewFile();
//        FileOutputStream fos = new FileOutputStream(f);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(phoneDiary);
            //phoneDiary.run();

//        try{
//            File f = new File("obj.txt");
//            FileOutputStream fos = new FileOutputStream(f);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            //oos.writeObject(phoneDiary);
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }


//        PhoneDiary pd = new PhoneDiary();
//        pd.run();
//        File f = new File("obj.txt");
//        FileOutputStream fos = new FileOutputStream(f);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(pd);

//        File fi = new File("obj.txt");
//        FileInputStream fis = new FileInputStream(fi);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        PhoneDiary phoneDiary = (PhoneDiary)ois.readObject();
//
//        phoneDiary.run();
//
//        File fii = new File("obj.txt");
//        FileOutputStream fosi = new FileOutputStream(fii);
//        ObjectOutputStream oosi = new ObjectOutputStream(fosi);
//        oosi.writeObject(phoneDiary);


//        File fi = new File("obj.txt");
//        FileInputStream fis = new FileInputStream(fi);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        PhoneDiary phonebook = (PhoneDiary)ois.readObject();
//
//        phonebook.run();
//
//        File f = new File("obj.txt");
//        FileOutputStream fos = new FileOutputStream(f);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(phonebook);

    }
}