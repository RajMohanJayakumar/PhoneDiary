import java.util.*;

public class Directory {

    Contact contactData;

    //Creating HashMap for Name-UUID record
    HashMap<String, String> mName_UUID = new HashMap<>();
    //Creating HashMap for Email-UUID record
    HashMap<String, String> mEmail_UUID = new HashMap<>();
    //Creating HashMap for UUID-ContactData record
    HashMap<String, Contact> mUUID_Data = new HashMap<>();

    //Creating TreeSet for name record to get sorted list while iterating
    TreeSet<String> mOrdered = new TreeSet<>();


    //Creating common Class variables to use inside the methods
    String mName, mPhone, mEmail, mUuid, mTemp;

    //Global counter used by different methods to provide series of numbers to the show method
    int mCount = 1;

    //Adds a record every time when called
    public void add() {
        Scanner scan = new Scanner(System.in);

        //Getting Name with input validations
        System.out.println("Enter the Name:");
        mName = validateName(scan.nextLine());

        // Getting Phone number with input validations
        System.out.println("Enter the Phone Number");
        mPhone = validatePhonenumber(scan.next());

        // Getting Email value with input validations
        System.out.println("Enter the Email Address");
        mEmail = validateEmail(scan.next());

        //Generating random UUID
        mUuid = UUID.randomUUID().toString();

        //Updating Name-UUID HashMap
        mName_UUID.put(mName, mUuid);

        //Updating Email-UUID HashMap
        mEmail_UUID.put(mEmail, mUuid);

        //Updating UUID-Contact HashMap
        mUUID_Data.put(mUuid, new Contact(mName, mPhone, mEmail));

        //Updating Name to TreeSet to Maintain Alphabetical Order
        mOrdered.add(mName);
    }

    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Search:");
        System.out.println("1.Search by Name");
        System.out.println("2.Search by Email");
        System.out.println("- Press anyother key to return to phonebook -");

        switch (scan.next()) {


            case "1": {
             /* Checking whether the record exists or not using (Name)
                and printing the values using show() method. */
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the name to be searched");
                mName = scan1.nextLine();
                //Converting the first letter to be Capital
                mName = mName.substring(0, 1).toUpperCase() + mName.substring(1);
                //Checking whether the name exists in Name-UUID HashMap
                if (mName_UUID.containsKey(mName)) {
                    mCount = 1;
                    show(mName_UUID.get(mName));
                    break;
                }
                System.out.println("--------------------------");
                System.out.println("No records found for Name : '" + mName + "' .. Try Again..");
                break;
            }

            case "2": {
                /* Checking whether the record exists or not using (Email)
                and printing the values using show() method. */
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the Email to be searched");
                mEmail = scan1.nextLine();
                //Checking whether the email exists in Email-UUID HashMap
                if (mEmail_UUID.containsKey(mEmail)) {
                    mCount = 1;
                    show(mEmail_UUID.get(mEmail));
                    break;
                }
                System.out.println("--------------------------");
                System.out.println("No records found for Email : '" + mEmail + "' .. Try Again..");
                break;
            }
            default:
                //Returning to phonebook
                System.out.println("--------------------------");
                System.out.println("Returning to Phone Book");
                return;
        }

    }

    public void remove() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Remove:");
        System.out.println("1.Remove by Name");
        System.out.println("2.Remove by email");
        System.out.println("- press anyother key to return to phonebook -");

        switch (scan.nextLine()) {

            case "1": {
             /* Checking whether the record exists or not using (Name)
                and removing the data using remove() method. */
                Scanner scan1 = new Scanner(System.in);

                System.out.println("Enter the name to remove the record..");
                mName = scan1.nextLine();

                //Changing first letter as uppercase if not typed as uppercase
                mName = mName.substring(0, 1).toUpperCase() + mName.substring(1);

                // Removing the record if it exists
                if (mName_UUID.containsKey(mName)) {
                    //Fetching Details from Contact record
                    contactData = mUUID_Data.get(mName_UUID.get(mName));
                    //Removing the record from Name-UUID HashMap
                    mName_UUID.remove(contactData.getmName());
                    //Removing the record from UUID-Data HashMap
                    mUUID_Data.remove(mName_UUID.get(mTemp));
                    //Removing the record from Email-UUID HashMap
                    mEmail_UUID.remove(contactData.getmEmail());
                    //Removing name from Name TreeSet
                    mOrdered.remove(contactData.getmName());

                    System.out.println("--------------------------");
                    System.out.println("Record Removed...");

                } else {
                    System.out.println("--------------------------");
                    System.out.println("Record not found..");
                    break;
                }
                break;
            }
            case "2": {
             /* Checking whether the record exists or not using (Email)
                and removing the data using remove() method. */
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the email to remove the record..");
                mTemp = scan1.nextLine();

                // Removing the record if it exists
                if (mEmail_UUID.containsKey(mTemp)) {
                    //Fetching Details from Contact record
                    contactData = mUUID_Data.get(mEmail_UUID.get(mTemp));
                    //Removing the record from Name-UUID HashMap
                    mName_UUID.remove(contactData.getmName());
                    //Removing the record from UUID-Data HashMap
                    mUUID_Data.remove(mEmail_UUID.get(contactData.getmEmail()));
                    //Removing the record from Email-UUID HashMap
                    mEmail_UUID.remove(contactData.getmEmail());
                    //Removing name from Name TreeSet
                    mOrdered.remove(contactData.getmName());

                    System.out.println("--------------------------");
                    System.out.println("Record Removed...");
                } else {
                    System.out.println("--------------------------");
                    System.out.println("Record not found..");
                    break;
                }
                break;
            }
            default:
                return;
        }
    }

    public void showAll() {
        mCount = 1;
        if (mOrdered.isEmpty()) {
            System.out.println("--------------------------");
            System.out.println("Phone Directory is Empty..");
        }
        //Iterating names one by one in sorted order using foreach loop
        for (String iterator : mOrdered) {
            show(mName_UUID.get(iterator));
            mCount++;
        }
    }

    //Edit Method to edit different values
    public void edit() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Edit:");
        System.out.println("1.Edit by Name");
        System.out.println("2.Edit by email");
        System.out.println("- press anyother key to return to phonebook -");

        //Passing control respective to the input value
        switch (scan.nextInt()) {
            case 1: {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the name to fetch the record..");
                mName = scan1.nextLine();
                //Changing first letter as uppercase if not typed as uppercase
                mName = mName.substring(0, 1).toUpperCase() + mName.substring(1);
                //Retrieving records if it exists
                if (mName_UUID.containsKey(mName)) {
                    contactData = mUUID_Data.get(mName_UUID.get(mName));
                    //Editing the fetched records using editWithContactData() method
                    editWithContactData(contactData, mName_UUID.get(mName));
                } else {
                    System.out.println("--------------------------");
                    System.out.println("Couldn't retrieve any records respective to the Name entered");
                }
                break;
            }
            case 2: {
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the email to fetch the record..");
                mEmail = scan1.nextLine();
                //Retrieving records if it exists
                if (mEmail_UUID.containsKey(mEmail)) {
                    contactData = mUUID_Data.get(mEmail_UUID.get(mEmail));
                    //Editing the fetched records using editWithContactData() method
                    editWithContactData(contactData, mEmail_UUID.get(mEmail));
                } else {
                    System.out.println("--------------------------");
                    System.out.println("Couldn't retrieve any records respective to the Email entered");
                }
                break;
            }
        }
    }

    public void editWithContactData(Contact contactData, String uuid) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Edit:");
        System.out.println("1.Edit Name");
        System.out.println("2.Edit Phone number");
        System.out.println("3.Edit Email");
        System.out.println("- press anyother key to exit -");

        String newValue;
        switch (scan.nextLine()) {
            case "1": {
                System.out.println("Enter a new name:");
                mTemp = scan.nextLine();
                //Changing first letter as uppercase if not typed in uppercase
                mTemp = mTemp.substring(0, 1).toUpperCase() + mTemp.substring(1);
                //Validating the new name input
                newValue = validateName(mTemp);
                //Saving the new value using save() method
                save(1, contactData, newValue, uuid);
                contactData = mUUID_Data.get(uuid);
                System.out.println("Editing other components..");
                //Editing other components in the contact using recursion
                editWithContactData(contactData, uuid);
                break;
            }
            case "2": {
                System.out.println("Enter a new phone number");
                mTemp = scan.nextLine();
                //Validating the new phone number input
                newValue = validatePhonenumber(mTemp);
                //Saving the new value using save() method
                save(2, contactData, newValue, uuid);
                contactData = mUUID_Data.get(uuid);
                System.out.println("Editing other components..");
                //Editing other components in the contact using recursion
                editWithContactData(contactData, uuid);
                break;
            }
            case "3": {
                System.out.println("Enter a new email");
                mTemp = scan.nextLine();
                //Validating the new email input
                newValue = validateEmail(mTemp);
                //Saving the new value using save() method
                save(3, contactData, newValue, uuid);
                contactData = mUUID_Data.get(uuid);
                System.out.println("Editing other components..");
                //Editing other components in the contact using recursion
                editWithContactData(contactData, uuid);
                break;
            }
            default:
                return;
        }
    }


    public void save(int componentToEdit, Contact contactData, String newValue, String uuid) {
        switch (componentToEdit) {
            case 1: {
                //Removing the record from Name-UUID HashMap
                mName_UUID.remove(contactData.getmName());
                //Updating new name with Name-UUID HashMap
                mName_UUID.put(newValue, uuid);
                //Replacing new record with the existing record in UUID-Data HashMap
                mUUID_Data.put(uuid, new Contact(newValue, contactData.getmPhonenumber(), contactData.getmEmail()));
                //Removing name from Name TreeSet
                mOrdered.remove(contactData.getmName());
                //Adding name to Name TreeSet
                mOrdered.add(newValue);
                break;
            }
            case 2: {
                //Replacing new record with the existing record in UUID-Data HashMap
                mUUID_Data.put(uuid, new Contact(contactData.getmName(), newValue, contactData.getmEmail()));
                break;
            }
            case 3: {
                //Removing the record from Email-UUID HashMap
                mEmail_UUID.remove(contactData.getmEmail());
                //Adding new email to Email-UUID HashMap
                mEmail_UUID.put(newValue, uuid);
                //Replacing new record with the existing record in UUID-Data HashMap
                mUUID_Data.put(uuid, new Contact(contactData.getmName(), contactData.getmPhonenumber(), newValue));
                break;
            }
        }
    }

    //To Show records from UUID-Data using uuid as a parameter
    public void show(String uuid) {
        //Printing the Headers when counter value equals to 1
        if (mCount == 1) {
            System.out.println("--------------------------");
            System.out.print("No.");
            System.out.format("%6s", " ");
            System.out.format("%-23s", "Name");
            System.out.format("%-23s", "Phone Number");
            System.out.format("%-20s", "Email");
            System.out.println();
        }

        //Getting Values corresponding to the UUID and storing it in contactData
        contactData = mUUID_Data.get(uuid);
        System.out.print(mCount);
        System.out.format("%6s", " ");
        System.out.format("%-23s", contactData.getmName());
        System.out.format("%-23s", contactData.getmPhonenumber());
        System.out.format("%-20s", contactData.getmEmail());
        System.out.println();
    }

    public String validateEmail(String mTemp) {
        while (true) {
            Scanner scan1 = new Scanner(System.in);
            //Spliting email value with respect to "@"
            String mTemp2[] = mTemp.split("@");
            //Checking whether there are only two strings after spliting with "@"
            if (!(mTemp2.length == 2))
                System.out.println("Invalid Email format..");
                //Checking whether the data exists already in the Email-UUID HashMap
            else if (mEmail_UUID.containsKey(mTemp))
                System.out.println("Email already exists..");
            else
                //Returning value if all the above conditions fails
                return mTemp;
            //Getting another input when there previous value is not accepted
            System.out.println("Enter a new Email address");
            mTemp = scan1.nextLine();
        }
    }

    public String validateName(String mTemp) {
        while (true) {
            Scanner scan1 = new Scanner(System.in);
            //Changing first letter as uppercase if not typed in uppercase
            mTemp = mTemp.substring(0, 1).toUpperCase() + mTemp.substring(1);
            if (mTemp == null || mTemp.isEmpty()) {
                System.out.println("No Entries found");
            } else if (mTemp.length() > 20) {
                System.out.println("Enter a name within the size of 20 Characters..");
            } else if (mName_UUID.containsKey(mTemp)) {
                System.out.println("Name already Exists..");
            } else
                return mTemp;
            System.out.println("Please enter a new name..");
            //Getting another input when there previous value is not accepted
            mTemp = scan1.nextLine();
        }
    }

    public String validatePhonenumber(String mTemp) {
        Scanner scan = new Scanner(System.in);
        invalid:
        while (true) {
            //Checking whether the size of phone number is between 5 and 20
            if (mTemp.length() > 20 || mTemp.length() < 5) {
                System.out.println("Enter a Valid Phone Number between the size of 5 and 20 characters");
                mTemp = scan.nextLine().trim();
            }
            for (int i = 0; i < mTemp.length(); i++) {
                //Checking whether all the entries has only numeric values or '+' sign
                if (!('0' <= mTemp.charAt(i) && mTemp.charAt(i) <= '9') || mTemp.charAt(i) == '+') {
                    System.out.println("Enter a Valid Phone Number");
                    mTemp = scan.nextLine().trim();
                    continue invalid;
                }
                if (i == mTemp.length() - 1)
                    return mTemp;
            }
            break;
        }
        return mTemp;
    }
}