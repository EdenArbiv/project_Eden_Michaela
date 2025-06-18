package project_Eden_Michaela;

import java.io.*;

public class BinaryFile {
    private final String filePath;
    private final String filename;
    public BinaryFile(String filename) {
        String packagePath = this.getClass().getPackage()
                .getName().replace('.', File.separatorChar);
        filePath = System.getProperty("user.dir") + File.separator + "src"
                + File.separator + packagePath + File.separator;
        this.filename = filename;
    }

    public void saveCollegeFile(College college) throws IOException {
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(filePath + filename));
        ois.writeObject(college);
        ois.close();
    }

    public College readCollegeFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath + filename));
        College college = (College) ois.readObject();
        ois.close();
        return college;
    }
}
