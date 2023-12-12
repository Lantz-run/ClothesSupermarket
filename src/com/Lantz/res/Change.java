package com.Lantz.res;

import java.io.*;
import java.util.Properties;

public class Change {
    public static void main(String[] args) {
        String inputFilePath = "src/com/Lantz/res/r_temp.properties";
        String outputFilePath = "src/com/Lantz/res/r1.properties";

        try {
            FileInputStream inputStream = new FileInputStream(inputFilePath);
            Properties properties = new Properties();

            // �����������������ļ�
            properties.load(new InputStreamReader(inputStream, "UTF-8"));
            inputStream.close();

            // ���������
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
//            OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
//            properties.store(writer, null);

            // �������Բ�ת�������ַ���д�������
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                value = escapeChineseToUnicode(value);
                properties.setProperty(key, value);
            }

            // ���浽�����
            properties.store(outputStream, null);
            outputStream.close();

            System.out.println("ת����ɣ�");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ת��ʧ��: " + e.getMessage());
        }
    }

    public static String escapeChineseToUnicode(String input) {
        StringBuilder output = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (character >= 128) {
                output.append("\\u").append(String.format("%04x", (int) character));
            } else {
                output.append(character);
            }
        }
        return output.toString();
    }
}
