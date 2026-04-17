/**
 * Day 22 - File Handling: Byte Streams
 *
 * <p>Demonstrates copying a file using {@link java.io.FileInputStream} and
 * {@link java.io.FileOutputStream}.
 *
 * <p>This example creates a small input file, copies it, and verifies the copy.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteStreamCopyExample {

    private static void writeBytes(String path, byte[] data) throws IOException {
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(data);
        }
    }

    private static byte[] readAllBytes(String path) throws IOException {
        try (FileInputStream in = new FileInputStream(path)) {
            byte[] buffer = new byte[1024];
            int read;
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            while ((read = in.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }
            return baos.toByteArray();
        }
    }

    private static void copy(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(target)) {

            byte[] buffer = new byte[256];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("=== Byte Stream Copy Example ===\n");

        String source = "byte-input.bin";
        String target = "byte-copy.bin";

        byte[] payload = ("Binary-like content\n" +
                "This file was created by ByteStreamCopyExample\n")
                .getBytes(StandardCharsets.UTF_8);

        System.out.println("Creating source file: " + source);
        writeBytes(source, payload);

        System.out.println("Copying to: " + target);
        copy(source, target);

        byte[] srcBytes = readAllBytes(source);
        byte[] dstBytes = readAllBytes(target);

        System.out.println("Source size: " + srcBytes.length + " bytes");
        System.out.println("Copy size:   " + dstBytes.length + " bytes");
        System.out.println("Copy matches source: " + java.util.Arrays.equals(srcBytes, dstBytes));
    }
}

