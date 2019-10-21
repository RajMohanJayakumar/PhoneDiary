import java.util.*;

public class Directory {

    Contact value = new Contact();

    HashMap<String, String> mName_UUID = new HashMap<>();/// keep this as string
    HashMap<String, String> mEmail_UUID = new HashMap<>(); ///  keep this as string
    HashMap<String, String> mUUID_Data = new HashMap<>();

//    UUID uuid = UUID.randomUUID();

//    public void addInEmailDB(String email, String id){
//
//        if(email == null || email.isEmpty())
//            return;
//
//        if(id == null || id.isEmpty())
//            return;
//
//        UUID.randomUUID().toString();
//        this.mEmail_UUID.put(email, id);
//
//    }
//
//    public String searchByEmail(String email){
//
//        if(email == null || email.isEmpty())
//            return null;
//
//        return this.mEmail_UUID.get(email);
//    }
//
//    public Contact getContact(String id){
//        if(id == null || id.isEmpty())
//            return null;
//       return this.mUUID_Data.get(id);
//    }


    String mTemp;
    String mTemp1[];
    int count = 1;

    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Name:");
        while (true) {
            mTemp = scan.nextLine();
            if (!mName_UUID.containsKey(mTemp)) {
                mTemp = mTemp.substring(0, 1).toUpperCase() + mTemp.substring(1);
                value.setmName(mTemp);
                break;
            }
            System.out.println("Name altready Exists.. Please enter an alternate name");
        }

        System.out.println("Enter the Phone Number");
        invalid:
        while (true) {
            value.setmPhonenumber(scan.next());
            for (int i = 0; i < value.getmPhonenumber().length(); i++) {
                if (!('0' <= value.getmPhonenumber().charAt(i) && value.getmPhonenumber().charAt(i) <= '9') || value.getmPhonenumber().charAt(i) == '+') {
                    System.out.println("Enter a Valid Phone Number");
                    continue invalid;
                }
                if (i == value.getmPhonenumber().length())
                    break;
            }
            break;
        }

        System.out.println("Enter the Email Address");
        while (true) {
            value.setmEmail(scan.next());
            mTemp1 = value.getmEmail().split("@");
            if (!(mTemp1.length == 2))
                System.out.println("Invalid Email format..");
            else if (!mEmail_UUID.containsKey(value.getmEmail()))
                break;
            System.out.println("Email already exists.. Please enter the new Email address");
        }

        value.setUuid(UUID.randomUUID().toString());

        mTemp = value.getmName() + "&/&" + value.getmPhonenumber() + "&/&" + value.getmEmail();

        mName_UUID.put(value.getmName(), value.getUuid());

        mEmail_UUID.put(value.getmEmail(), value.getUuid());

        mUUID_Data.put(value.getUuid(), mTemp);
    }

    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Search:");
        System.out.println("1.Search by Name");
        System.out.println("2.Search by Email");
        System.out.println("- Press anyother key to return to phonebook -");

        switch (scan.next()) {
            case "1": {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the name to be searched");
                mTemp = scan1.nextLine();
                mTemp = mTemp.substring(0, 1).toUpperCase() + mTemp.substring(1);
                if (mName_UUID.containsKey(mTemp)) {
                    show(mName_UUID.get(mTemp));
                    count = 1;
                    break;
                }
                System.out.println("Record Not Found.. Try Again..");
                break;
            }

            case "2": {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the Email to be searched");
                mTemp = scan1.nextLine();
//                mTemp = mTemp.substring(0,1).toUpperCase()+mTemp.substring(1);
                if (mEmail_UUID.containsKey(mTemp)) {
                    show(mEmail_UUID.get(mTemp));
                    count = 1;
                    break;
                }
                System.out.println("Record Not Found.. Try Again..");
                break;
            }
            default:
                System.out.println("Returning to Phone Book");
                return;
        }

    }

    public void remove() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Remove:");
        System.out.println("1.Remove by Name");
        System.out.println("2.Remove by email");
        System.out.println("- Press anyother key to return to phonebook -");

        switch (scan.nextInt()) {
            case 1: {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the email to fetch the record..");
                mTemp = scan1.nextLine();
                if (mEmail_UUID.containsKey(mTemp)) {
                    mTemp1 = mUUID_Data.get(mTemp).split("&/&");

                    System.out.println("Enter the Email Address");

                    mTemp = mTemp1[0] + "&/&" + mTemp1[1] + "&/&" + mTemp1[2];
                }
            }
        }
    }

    public void showAll(){
        count = 1;
        for(String iterations : mUUID_Data.keySet()){
            show(iterations);
            count++;
        }
    }
    public void edit() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Edit:");
        System.out.println("1.Edit by Name");
        System.out.println("2.Edit by email");
        System.out.println("- Press anyother key to return to phonebook -");

        switch (scan.nextInt()) {
            case 1: {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the name to fetch the record..");
                mTemp = scan1.nextLine();
                mTemp = mTemp.substring(0,1).toUpperCase()+mTemp.substring(1);
                if (mName_UUID.containsKey(mTemp)){
                    editBy(1,mName_UUID.get(mTemp));
                    break;
                }
                break;
            }
            case 2: {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the email to fetch the record..");
                mTemp = scan1.nextLine();
                if (mEmail_UUID.containsKey(mTemp)) {
                    editBy(2,mEmail_UUID.get(mTemp));
                    break;
                }
                break;
            }
        }
    }

    public void show(String id) {
        if (count == 1) {
            System.out.print("No.");
            System.out.format("%6s", " ");
            System.out.format("%-20s", "Name");
            System.out.format("%-20s", "Phone Number");
            System.out.format("%-20s", "Email");
            System.out.println();
        }

        mTemp1 = mUUID_Data.get(id).split("&/&");
        System.out.print(count);
        System.out.format("%6s", " ");
        System.out.format("%-20s", mTemp1[0]);
        System.out.format("%-20s", mTemp1[1]);
        System.out.format("%-20s", mTemp1[2]);
        System.out.println();
    }

    public String validateEmail(String mTemp) {
        while (true) {
            Scanner scan1 = new Scanner(System.in);
            String mTemp2[] = mTemp.split("@");
            if (!(mTemp2.length == 2))
                System.out.println("Invalid Email format..");
            else if (mEmail_UUID.containsKey(mTemp))
                System.out.println("Email already exists..");
            else
                return mTemp;
            System.out.println("Enter a new Email address");
            mTemp = scan1.nextLine();
        }
    }

    public String validateName(String mTemp) {
        while(true) {
            Scanner scan1 = new Scanner(System.in);
            mTemp = mTemp.substring(0,1).toUpperCase()+mTemp.substring(1);
            if (mTemp == null || mTemp.isEmpty()) {
                System.out.println("No Entries found");
            } else if (mName_UUID.containsKey(mTemp)) {
                System.out.println("Name already Exists..");
            } else
                return mTemp;
            System.out.println("Enter a new name");
            mTemp = scan1.nextLine();
        }
    }

    public String validatePhonenumber(String mTemp) {
        Scanner scan = new Scanner(System.in);
        invalid:
        while (true) {
            for (int i = 0; i < mTemp.length(); i++) {
                if (!('0' <= mTemp.charAt(i) && mTemp.charAt(i) <= '9') || mTemp.charAt(i) == '+') {
                    System.out.println("Enter a Valid Phone Number");
                    mTemp = scan.nextLine().trim();
                    continue invalid;
                }
                if (i == mTemp.length()-1)
                    return mTemp;
            }
            break;
        }
        return mTemp;
    }

    public void editName(String mTemp) {
//        {
//            Scanner scan1 = new Scanner(System.in);
//            mTemp1 = mUUID_Data.get(mEmail_UUID.get(mTemp)).split("&/&");
//            System.out.println("Enter the new email");
//            mTemp = validateEmail(scan1.nextLine());
//            mTemp = mTemp1[0] + "&/&" + mTemp1[1] + "&/&" + mTemp;
//            mUUID_Data.put(mEmail_UUID.get(mTemp1[2]), mTemp);
//            mEmail_UUID.remove(mTemp1[2]);
//            mEmail_UUID.put(mTemp, mName_UUID.get(mTemp1[0]));
//        }
    }

    public void editBy(int editBy,String uuid) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Edit:");
        System.out.println("1.Edit Name");
        System.out.println("2.Edit Phone number");
        System.out.println("3.Edit Email");
        System.out.println("- Press anyother key to exit -");

        String newValue;
        switch (scan.nextLine()) {
            case "1": {
                System.out.println("Enter a new name:");
                mTemp = scan.nextLine();
                mTemp = mTemp.substring(0,1).toUpperCase()+mTemp.substring(1);
                newValue = validateName(mTemp);
                editbyComponent(editBy, 1, newValue, uuid);
                break;
            }
            case "2": {
                System.out.println("Enter a new phone number");
                mTemp = scan.nextLine();
                newValue = validatePhonenumber(mTemp);
                editbyComponent(editBy, 2, newValue, uuid);
                break;
            }
            case "3": {
                System.out.println("Enter a new email");
                mTemp = scan.nextLine();
                newValue = validateEmail(mTemp);
                editbyComponent(editBy, 3, newValue, uuid);
                break;
            }
        }
    }

    public void editbyComponent(int componentToSearchBy, int componentToEdit, String newValue, String uuid) {

        switch (componentToSearchBy) {
            case 1: {
//                String uuid = mEmail_UUID.get(uuid);
                String data[] = mUUID_Data.get(uuid).split("&/&");
                save(componentToEdit, newValue, data,uuid);
            }break;
            case 2: {
//                String uuid = mName_UUID.get(uuid);
//                System.out.println(uuid);
//                System.out.println(mUUID_Data.get(uuid).split("&/&"));
                String data[] = mUUID_Data.get(uuid).split("&/&");
                save(componentToEdit, newValue, data,uuid);
                break;
            }
        }
    }

    public void save(int componentToEdit, String newValue, String[] data,String uuid) {
        switch (componentToEdit) {
            case 1: {
                mName_UUID.remove(data[0]);
                mName_UUID.put(newValue, uuid);
                mUUID_Data.put(uuid, newValue + "&/&" + data[1] + "&/&" + data[2]);
                break;
            }
            case 2: {
                mUUID_Data.put(uuid, data[0] + "&/&" + newValue + "&/&" + data[2] +"&/&");
                System.out.println(data[0] + "&/&" + newValue + "&/&" + data[2]);
                mUUID_Data.get(uuid);
                break;
            }
            case 3: {
                mEmail_UUID.remove(data[2]);
                mEmail_UUID.put(newValue, uuid);
                mUUID_Data.put(uuid, data[0] + "&/&" + data[1] + "&/&" + newValue);
                break;
            }
        }
    }
}