import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hospital {
    String name;
    String city;
    int beds;
    double price;
    double rating;
    int reviews;

    Hospital(String name, String city, int beds, double price, double rating, int reviews) {
        this.name = name;
        this.city = city;
        this.beds = beds;
        this.price = price;
        this.rating = rating;
        this.reviews = reviews;
    }

    public void printHospital() {
        System.out.println("Hastane: " + this.name);
        System.out.println("Sehir: " + this.city);
        System.out.println("Toplam yatak kapasitesi: " + this.beds);
        System.out.println("Gunluk Kalma Ucreti: " + this.price);
        System.out.println("Puani: " + this.rating);
        System.out.println("Yorum Sayisi: " + this.reviews);
        System.out.println();
    }
}

class Patient {
    String name;
    int age;

    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printPatient() {
        System.out.println("Hastanin adi: " + this.name);
        System.out.println("Hastanin yasi: " + this.age);
        System.out.println();

    }
}

public class Main {

    static ArrayList<Hospital> hospitals = new ArrayList<>();
    static List<List<Patient>> patients = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void printAllHospitals() {
        for (int i = 0; i < hospitals.size(); i++) {
            System.out.println((i + 1) + ". Hastanem:");
            hospitals.get(i).printHospital();
        }
    }

    public static void printAllPatients() {
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". Hastanem: " + hospitals.get(i).name);
            System.out.println();
            for (int j = 0; j < patients.get(i).size(); j++) {
                System.out.println((j + 1) + ". Hastam:");
                patients.get(i).get(j).printPatient();
            }
        }
    }

    public static void printHospitalsInCity() {
        String city;
        System.out.print("Lutfen Sehir Seciniz(Ankara, Izmir,Istanbul)");
        city = scanner.next();
        System.out.println(city + " sehrindeki hastaneler: ");
        for (Hospital hospital : hospitals) {
            if (hospital.city.equalsIgnoreCase(city)) {
                hospital.printHospital();
            }

        }
    }

    public static void sortHospitalByPrice() {
        for (int i = 0; i < hospitals.size() - 1; i++) {
            for (int j = 0; j < hospitals.size() - 1 - i; j++) {
                if (hospitals.get(j).price > hospitals.get(j + 1).price) {
                    Hospital temp = hospitals.get(j);
                    hospitals.set(j, hospitals.get(j + 1));
                    hospitals.set(j + 1, temp);
                }
            }
        }
        printAllHospitals();
    }

    public static void sortHospitalsByBeds() {
        for (int i = 0; i < hospitals.size() - 1; i++) {
            for (int j = 0; j < hospitals.size() - 1 - i; j++) {
                if (hospitals.get(j).beds < hospitals.get(j + 1).beds) {
                    Hospital temp = hospitals.get(j);
                    hospitals.set(j, hospitals.get(j + 1));
                    hospitals.set(j + 1, temp);
                }
            }
        }
        printAllHospitals();
    }

    public static void sortHospitalsByRating() {
        for (int i = 0; i < hospitals.size() - 1; i++) {
            for (int j = 0; j < hospitals.size() - 1 - i; j++) {
                if (hospitals.get(j).rating < hospitals.get(j + 1).rating) {
                    Hospital temp = hospitals.get(j);
                    hospitals.set(j, hospitals.get(j + 1));
                    hospitals.set(j + 1, temp);
                }
            }
        }
        printAllHospitals();
    }

    public static void sortHospitalsByName() {
        for (int i = 0; i < hospitals.size() - 1; i++) {
            for (int j = 0; j < hospitals.size() - 1 - i; j++) {
                if (hospitals.get(j).name.compareTo(hospitals.get(j + 1).name) > 0) {
                    Hospital temp = hospitals.get(j);
                    hospitals.set(j, hospitals.get(j + 1));
                    hospitals.set(j + 1, temp);
                }
            }
        }
        printAllHospitals();
    }

    public static void showMenu() {
        int choice;

        do {
            System.out.println("**************Hastane Yonetim Sistemi****************");
            System.out.println("1. Hastane Bilgilerini Bastir");
            System.out.println("2. Hasta Bilgilerini Bastir");
            System.out.println("3. Hastaneleri Gunluk Kalma Ucretine Gore Sirala");
            System.out.println("4. Hastaneleri Yatak Sayisina Gore Sirala(Azalan)");
            System.out.println("5. Hastaneleri Adina Gore Sirala");
            System.out.println("6. Hastaneleri Puanina Gore Sirala");
            System.out.println("7. Girilen Sehirdeki Hastaneleri Bastir");
            System.out.println("8. Cikis Yap");
            System.out.print("Seciminizi yapiniz: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printAllHospitals();
                    break;
                case 2:
                    printAllPatients();
                    break;
                case 3:
                    sortHospitalByPrice();
                    break;
                case 4:
                    sortHospitalsByBeds();
                    break;
                case 5:
                    sortHospitalsByName();
                    break;
                case 6:
                    sortHospitalsByRating();
                    break;
                case 7:
                    printHospitalsInCity();
                    break;
                case 8:
                    System.out.println("Cikis yapiliyor");
                    break;
                default:
                    System.out.println("Gecersiz islem! Tekrar deneyiniz!");
                    break;
            }

        } while (choice != 8);

    }

    public static void main(String[] args) {
        hospitals.add(new Hospital("Can", "Istanbul", 100, 250, 4.5, 100));
        hospitals.add(new Hospital("Balkan", "Ankara", 150, 200, 4.2, 80));
        hospitals.add(new Hospital("Balbadem", "Istanbul", 200, 180, 4.0, 120));
        hospitals.add(new Hospital("Edikol", "Izmir", 80, 300, 4.8, 90));
        hospitals.add(new Hospital("Mekol", "Ankara", 120, 220, 4.6, 110));

        List<Patient> patients1 = new ArrayList<>();
        patients1.add(new Patient("Osman", 35));
        patients1.add(new Patient("Hakan", 45));
        patients1.add(new Patient("Elif", 28));

        List<Patient> patients2 = new ArrayList<>();
        patients2.add(new Patient("Can", 62));
        patients2.add(new Patient("Kerem", 18));
        patients2.add(new Patient("Mazlum", 55));

        List<Patient> patients3 = new ArrayList<>();
        patients3.add(new Patient("Zafer", 50));
        patients3.add(new Patient("Melis", 30));
        patients3.add(new Patient("Fulya", 40));

        List<Patient> patients4 = new ArrayList<>();
        patients4.add(new Patient("Mert", 22));
        patients4.add(new Patient("Asli", 38));
        patients4.add(new Patient("Beyza", 60));

        List<Patient> patients5 = new ArrayList<>();
        patients5.add(new Patient("Ada", 28));
        patients5.add(new Patient("Celil", 48));
        patients5.add(new Patient("Ozan", 33));

        // Hastaları listeye ekle
        patients.add(patients1);
        patients.add(patients2);
        patients.add(patients3);
        patients.add(patients4);
        patients.add(patients5);

        showMenu();

    }
}