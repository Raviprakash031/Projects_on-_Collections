import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Patients{
  private static  int nextId=1;
  private int id;
  private String name; 
  private int age;
  private String  gender;
  private long aadharCardNumber;
  private long contactNumber; 
  private String city;
  private String address;
  private Date dateOfAdmission; 
  private String guardiansName;
  private String guardiansAddress;
  private long guardiansContact;
  private boolean recovered;
  public Patients(String name,int age,String gender,long aadharCardNumber,long contactNumber,String city,String address,Date dateOfAdmission,String guardiansName,String guardiansAddress,long guardiansContact){
    this.id=nextId++;
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.aadharCardNumber=aadharCardNumber;
    this.contactNumber=contactNumber;
    this.city=city;
    this.address=address;
    this.dateOfAdmission=dateOfAdmission;
    this.guardiansName=guardiansName;
    this.guardiansAddress=guardiansAddress;
    this.guardiansContact=guardiansContact;
    this.recovered=false;
  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public long getAadharCardNumber() {
	return aadharCardNumber;
}
public void setAadharCardNumber(long aadharCardNumber) {
	this.aadharCardNumber = aadharCardNumber;
}
public long getContactNumber() {
	return contactNumber;
}
public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getDateOfAdmission() {
	return dateOfAdmission;
}
public void setDateOfAdmission(Date dateOfAdmission) {
	this.dateOfAdmission = dateOfAdmission;
}
public String getGuardiansName() {
	return guardiansName;
}
public void setGuardiansName(String guardiansName) {
	this.guardiansName = guardiansName;
}
public String getGuardiansAddress() {
	return guardiansAddress;
}
public void setGuardiansAddress(String guardiansAddress) {
	this.guardiansAddress = guardiansAddress;
}
public long getGuardiansContact() {
	return guardiansContact;
}
public void setGuardiansContact(long guardiansContact) {
	this.guardiansContact = guardiansContact;
}
  public boolean isRecovered(){
    return recovered;
  }
  public void setRecovered(boolean recovered){
    this.recovered=recovered;
  }
}
class InvalidIdException extends Exception{
  public InvalidIdException(String msg){
    super(msg);
  }
}
class InvalidAgeException extends Exception{
  public InvalidAgeException(String msg){
    super(msg);
  }
}
class Hospital{
  private HashMap<Integer,Patients>patients=new HashMap<Integer,Patients>();
  public void addPatientDetails(Patients patient){
      patients.put(patient.getId(),patient);
    System.out.println("Patient Details added successfully");
  }
  public void listofPatientsDetails(){
    boolean check =patients.isEmpty();
    if(check==false){
    for(Patients patient:patients.values()){
    System.out.println("Id:"+patient.getId());
    System.out.println("Name:"+patient.getName());
    System.out.println("Age: "+patient.getAge());
    System.out.println("Gender: "+patient.getGender());
    System.out.println("Mobile: "+patient.getContactNumber());
    System.out.println("city: "+patient.getCity());
    System.out.println("Address: "+patient.getAddress());
      System.out.println("date of admission"+patient.getDateOfAdmission());
    System.out.println("Gyardians Name: "+patient.getGuardiansName());
    System.out.println("Guardians Address: "+patient.getGuardiansAddress());
    System.out.println("Guardians Mobile:"+patient.getGuardiansContact());
    }
    }
    else{
      System.out.println("Collection is empty");
    }
  }
  public Patients getPatientById(int id){
    return patients.get(id);
  }
  List<Patients> getPatientByCity(String city){
    List<Patients> inCity=new ArrayList<>();
    for(Patients patient:patients.values()){
      if(patient.getCity().equalsIgnoreCase(city)){
        inCity.add(patient);
      }
    }
    return inCity;
  }
  List<Patients> getAgeGroup(int maxAge,int minAge){
   List<Patients> byAge=new ArrayList<>();
    for(Patients patient:patients.values()){
      //Exception Handling
      try{
        if(patient.getAge()<0){
          throw new InvalidAgeException("age sholuld be greater than 0");
        }
        else{
          if(patient.getAge()>=minAge && patient.getAge()<=maxAge){
             byAge.add(patient);
           }
        }
      }
      catch(InvalidAgeException e){
        System.out.println(e.getMessage());
      }
    }
    return byAge;
  }
    
    
  
  public void deletePatientDetails(int id){
    boolean check =patients.isEmpty();
    //Exception handling
    try{
    if(check!=false){
      throw new InvalidIdException("id is not valid");
    }
    else{
      patients.remove(id);
      System.out.println(id+"patient will be deleted");
    }
    }
    catch(InvalidIdException e){
      System.out.println(e.getMessage());
    }
    System.out.println("no details found for that id");
  }
  public void displayAllPatient(){
    boolean check =patients.isEmpty();
    if(check==false){
    for(Patients patient:patients.values()){
    System.out.println("Id:"+patient.getId());
    System.out.println("Name:"+patient.getName());
    System.out.println("Age: "+patient.getAge());
    System.out.println("Gender: "+patient.getGender());
    System.out.println("Mobile: "+patient.getContactNumber());
    System.out.println("city: "+patient.getCity());
    System.out.println("Address: "+patient.getAddress());
      System.out.println("date of admission"+patient.getDateOfAdmission());
    System.out.println("Gyardians Name: "+patient.getGuardiansName());
    System.out.println("Guardians Address: "+patient.getGuardiansAddress());
    System.out.println("Guardians Mobile:"+patient.getGuardiansContact());
    }
    }
    else{
      System.out.println("Collection is empty");
    }
  }
  public void checkPatientRecovered(int id){
    Patients patient=patients.get(id);
    if(patient!=null){
      
      System.out.println(patient.isRecovered()+"patient is not recoverd");
      
    }
    else{
      System.out.println("There is no patient to recoverd");
    }
  }
}
class InvalidContactNumber extends Exception{
  InvalidContactNumber(String msg){
    super(msg);
  }
}
class InvalidAadharNumber extends Exception{
  InvalidAadharNumber(String msg){
    super(msg);
  }
}
public class ArogyaHospitalProgram{
  public static void main(String [] args) throws Exception{
    Scanner sc=new Scanner(System.in);
    Hospital hos=new Hospital();
     while(true){
      System.out.println("*******Welcome to student management System**********");
    System.out.println("1.addPatientDetails\n2.Display list of patients\n3.Patient details by id\n4.getpatient by city\n5.patient details by age\n6.delete patients by id\n7.dispaly patient details\n8.recovered or not");
    System.out.println("enteer the choice");
    int choice=sc.nextInt();
    switch(choice){
      case 1:
    //System.out.println("enter the number of patients ");
    //int n=sc.nextInt();
    //Patients a[]=new Patients[n];
    //for(int i=0;i<n;i++){*/
    //Patients pat=new Patients("ravi", 21," male", 4672845, 6303,"vijayawada"," ummayapalli","16-04-2025", "mohan","ummayapalli", 967692);
    //Patients pat1=new Patients("prasad",21,"male",630371,3698452,"Mangalagiri","palakullu","12-9-2022","gana","palakullu",967693);
    //hos.addPatientDetails(pat);
    System.out.println("enter the name of the patient");
        sc.nextLine();
      String Name=sc.nextLine();
       System.out.println("enter the age of the patient");
      int age=sc.nextInt();
       if(age<0){
         System.out.println("age should be greater than 0");
         return;
       } 
      System.out.println("enter the gender of the patient");
        sc.nextLine();
      String gender=sc.nextLine();
      System.out.println("enter the aadhar of the patient");
      long aadharCardNumber=sc.nextLong();
        if(100000000000l <=aadharCardNumber && 999999999999l>=aadharCardNumber){
            aadharCardNumber=aadharCardNumber;
          }
          else{
            try{
              throw new InvalidAadharNumber("Invalid Aadhar Number");
            }
            catch(InvalidAadharNumber e){
              System.out.println("Exception: "+e.getMessage());
            }
          }
      System.out.println("enter the mobile of the patient");
        //validations
        long contactNumber=sc.nextLong();
        if(1000000000l<=contactNumber && 9999999999l>=contactNumber){
            contactNumber=contactNumber;
          }
          else{
            try{
              throw new InvalidContactNumber("InvalidMobileNumber");
            }
            catch(InvalidContactNumber e){
              System.out.print("Exception: "+e.getMessage());
            }
          }
      System.out.println("enter the city of the patient");
        sc.nextLine();
      String city=sc.nextLine();
      System.out.println("enter the address of the patient");
      String address=sc.nextLine();
      System.out.println("enter the date of admission of the patient");
      String dateOfAdmission=sc.nextLine();
        DateFormat date=new SimpleDateFormat("DD-MM-YYYY");
        Date presentDate=date.parse(dateOfAdmission);
      System.out.println("enter the guardians name of the patient");
      String gurdiansName=sc.nextLine();
      System.out.println("enter the guardians address of the patient");
      String guardiansAddress=sc.nextLine();
      System.out.println("enter the guardians contact of the patient");
      long guardiansContact=sc.nextLong();
    Patients p=new Patients(Name,age,gender,aadharCardNumber,contactNumber,city,address,presentDate,gurdiansName,guardiansAddress,guardiansContact);
        hos.addPatientDetails(p);
        
    break;
      case 2:
        System.out.println("Display list of patient details");
       hos.listofPatientsDetails();
        break;
      case 3:
        System.out.println("enter the id to dispaly the patient based on id");
    Patients retrivedPatient=hos.getPatientById(sc.nextInt());
    if(retrivedPatient!=null){
    System.out.println("patient details by Id are:");
    System.out.println("Name:"+retrivedPatient.getName());
    System.out.println("Age: "+retrivedPatient.getAge());
    System.out.println("Gender: "+retrivedPatient.getGender());
    System.out.println("Mobile: "+retrivedPatient.getContactNumber());
    System.out.println("city: "+retrivedPatient.getCity());
    System.out.println("Address: "+retrivedPatient.getAddress());
      System.out.println("date of admission"+retrivedPatient.getDateOfAdmission());
    System.out.println("Gyardians Name: "+retrivedPatient.getGuardiansName());
    System.out.println("Guardians Address: "+retrivedPatient.getGuardiansAddress());
    System.out.println("Guardians Mobile:"+retrivedPatient.getGuardiansContact());
      sc.nextLine();
    }
    else {
      System.out.println("no patient details fot that id ");
    }

    break;
      case 4:
        System.out.println("enter the city name to display");
        sc.nextLine();
    List<Patients> cityVija=hos.getPatientByCity(sc.nextLine());
     if(cityVija!=null){   
    for(Patients patient:cityVija){
    System.out.println("patient details by city are");
     System.out.println("Id:"+patient.getId());
    System.out.println("Name:"+patient.getName());
    System.out.println("Age: "+patient.getAge());
    System.out.println("Gender: "+patient.getGender());
    System.out.println("Mobile: "+patient.getContactNumber());
    System.out.println("city: "+patient.getCity());
    System.out.println("Address: "+patient.getAddress());
      System.out.println("date of admission"+patient.getDateOfAdmission());
    System.out.println("Gyardians Name: "+patient.getGuardiansName());
    System.out.println("Guardians Address: "+patient.getGuardiansAddress());
    System.out.println("Guardians Mobile:"+patient.getGuardiansContact());
      sc.nextLine();
    }
       
      
  }
  else{
          System.out.println("Patient details is not found for that city");
        }
    
       break;
      case 5:
        System.out.println("enter the min and max age");
    int maxAge=sc.nextInt();
    int minAge=sc.nextInt();
    List<Patients> ageGroup=hos.getAgeGroup(maxAge,minAge);
        if(ageGroup!=null){
      for(Patients patient:ageGroup){
    System.out.println("patient details by the age group between the min and max age are:");
    System.out.println("Id:"+patient.getId());
    System.out.println("Name:"+patient.getName());
    System.out.println("Age: "+patient.getAge());
    System.out.println("Gender: "+patient.getGender());
    System.out.println("Mobile: "+patient.getContactNumber());
    System.out.println("city: "+patient.getCity());
    System.out.println("Address: "+patient.getAddress());
        System.out.println("date of admission"+patient.getDateOfAdmission());
    System.out.println("Gyardians Name: "+patient.getGuardiansName());
    System.out.println("Guardians Address: "+patient.getGuardiansAddress());
    System.out.println("Guardians Mobile:"+patient.getGuardiansContact());
      }
      
      
    }
        else{
          System.out.println("Patient details is not found for that age");
        }
       break;
      case 6:
        System.out.println("enter the id to rmove the details");
        hos.deletePatientDetails(sc.nextInt());
        
        break;
      case 7:
        
       System.out.println("Display patient details");
       hos.displayAllPatient();
        break;
      case 8:
        System.out.println("enter the id that patient is recovered");
        hos.checkPatientRecovered(sc.nextInt());
        
        break;
      default:
        System.out.println("invalid choice");
        System.exit(0);
    }
    }
  }
}
