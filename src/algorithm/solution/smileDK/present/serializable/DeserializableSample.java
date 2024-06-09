package algorithm.solution.smileDK.present.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializableSample {
    public static void main(String[] args) {
        // 외부 파일명
        String fileName = "Customer1.ser";

        // 파일 스트림 객체 생성 (try with resource)
        try (
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
            // 바이트 스트림을 다시 자바 객체로 변환(캐스팅 강제)
            Customer deserializedCustomer = (Customer) ois.readObject();
            System.out.println(deserializedCustomer);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
