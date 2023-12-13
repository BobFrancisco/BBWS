package project;

public class Staff {
    private String name;

    private int age;

    private String education;

    public Staff() {
    }

    public Staff(String name, int age, String education) {
        this.name = name;
        this.age = age;
        this.education = education;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                '}';
    }


    // calculate the selection probably according to age and education
    public  double calculateSelectionProbability() {
        double ageWeight = calculateAgeWeight(this.age);
        double educationWeight = calculateEducationWeight(this.education);

        return ageWeight * educationWeight;
    }

    // calculate the weight according to age
    public static double calculateAgeWeight(int age) {
        if (age >= 20 && age <= 25) {
            return 0.9; // the weight between 20 and 25 is 0.9
        } else if (age > 25 && age <= 30) {
            return 0.8; // the weight between 25 and 30 is 0.8
        }  else if (age > 30 && age <= 35) {
            return 0.7; // the weight between 30 and 35 is 0.7
        }else if (age > 35 && age <= 40) {
            return 0.6; // the weight between 35 and 40 is 0.6
        }  else {
            return 0.5; // the weight of other ages is 0.5
        }
    }

    // calculate the weight according to academic qualifications
    public static double calculateEducationWeight(String education) {
        if (education.equals("bachelor")) {
            return 0.7; // the weight of bachelor is 0.7
        } else if (education.equals("master")) {
            return 0.8; // the weight of  master is 0.7
        } else if (education.equals("docter")) {
            return 0.9; //the weight of  docter is 0.8
        }else if (education.equals("postdoctor")) {
            return 1; // the weight of  postdocter is 0.9
        }else {
            return 0.5; // the weight of else is 0.5
        }
    }
}

