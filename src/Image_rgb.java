import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class Image_rgb {
    private static void writeNumbersToFile(String filePath, List<Integer> numbers) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (int number : numbers) {
            writer.write(number + " ");
        }
        writer.close();
    }
    public static List<Integer> readNumbersFromFile(String filePath) throws FileNotFoundException {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();
        return numbers;
    }

    //функция чтения из файла
    public static String readFileToString(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void createImage(String textFilePath, String imageFilePath) {/// текстовый файл -> фото
        try {
            // Открываем текстовый файл
            File file = new File(textFilePath);
            Scanner scanner = new Scanner(file);

            // Получаем размеры изображения из первой строки файла
            int width = 300;
            int height = 300;

            // Создаем новое изображение
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Заполняем изображение значениями RGB из файла
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int r = scanner.nextInt();
                    int g = scanner.nextInt();
                    int b = scanner.nextInt();
                    int pixel = (r << 16) | (g << 8) | b;
                    image.setRGB(x, y, pixel);
                }
            }

            // Закрываем сканер
            scanner.close();

            // Сохраняем изображение в файл
            File outputfile = new File(imageFilePath);
            ImageIO.write(image, "png", outputfile);


        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении изображения: " + e.getMessage());
        }
    }

    public static void SavePixels(String imagePath, String outputFilePath) throws IOException {
        // Загружаем изображение
        BufferedImage image = ImageIO.read(new File(imagePath));

        // Получаем ширину и высоту изображения
        int width = image.getWidth();
        int height = image.getHeight();

        // Создаем объект FileWriter для записи в файл
        FileWriter writer = new FileWriter(outputFilePath);

        // Проходим по каждому пикселю изображения // запись в файл: R G B
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Получаем цвет пикселя
                int pixel = image.getRGB(x, y);
                int alpha = (pixel >> 24) & 0xff; // Альфа-канал прозрачность ????????? для чб по большому счету нафиг не надо там все равно всегда 255 !!!! проверить для оттенков серого
                int red = (pixel >> 16) & 0xff;   // Красный канал
                int green = (pixel >> 8) & 0xff;  // Зеленый канал
                int blue = pixel & 0xff;          // Синий канал
                //System.out.println("The number is: " + alpha); //=255
                if (x == width - 1) {// Записываем цвет пикселя в файл
                    writer.write(Integer.toString(red) + " ");
                    writer.write(Integer.toString(green) + " ");
                    writer.write(Integer.toString(blue));
                } else {
                    // Записываем цвет пикселя в файл
                    writer.write(Integer.toString(red) + " ");
                    writer.write(Integer.toString(green) + " ");
                    writer.write(Integer.toString(blue) + " ");
                }
            }
            writer.write("\n");
        }

        // Закрываем writer, чтобы сохранить изменения в файле
        writer.close();
    }

    /// сохранение чб изображения где 1 байт задает цветность
    public static void Save_black_wight_0_1(String image_bw, String outputFilePath) throws IOException {
        // Загружаем изображение
        BufferedImage image = ImageIO.read(new File(image_bw));

        // Получаем ширину и высоту изображения
        int width = image.getWidth();
        int height = image.getHeight();

        // Создаем объект FileWriter для записи в файл
        FileWriter writer = new FileWriter(outputFilePath);

        // Проходим по каждому пикселю изображения // запись в файл: R G B
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Получаем цвет пикселя
                int pixel = image.getRGB(x, y);
                // int alpha = (pixel >> 24) & 0xff; // Альфа-канал прозрачность ????????? для чб по большому счету нафиг не надо там все равно всегда 255 !!!! проверить для оттенков серого
                int red = (pixel >> 16) & 0xff;   // Красный канал
                int green = (pixel >> 8) & 0xff;  // Зеленый канал
                int blue = pixel & 0xff;          // Синий канал
                //System.out.println("The number is: " + alpha); //=255
                if (red == 255 && green == 255 && blue == 255) {
                    // Записываем цвет пикселя в файл
                    writer.write(Integer.toString(1));
                } else {
                    writer.write(Integer.toString(0));
                }
            }
            //writer.write( "\n");
        }
        // Закрываем writer, чтобы сохранить изменения в файле
        writer.close();
    }


    public static void create_bw_Image_from_0_1(String textFilePath, String imageFilePath) {/// текстовый файл -> фото
        try {
            // Открываем текстовый файл
            File file = new File(textFilePath);
            FileReader reader = new FileReader(file);

            // Получаем размеры изображения из первой строки файла
            int width = 300;
            int height = 300;

            // Создаем новое изображение
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            int black_or_wight;
            // Заполняем изображение значениями RGB из файла
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    black_or_wight = reader.read();
                    int pixel;
                    if (black_or_wight == 49)//// посмотреть кодировку UTF-8???????????????????????
                    {
                        pixel = (255 << 16) | (255 << 8) | 255;
                    } else {
                        pixel = (0 << 16) | (0 << 8) | 0;
                    }
                    image.setRGB(x, y, pixel);
                }
            }

            // Закрываем сканер
            reader.close();

            // Сохраняем изображение в файл
            File outputfile = new File(imageFilePath);
            ImageIO.write(image, "png", outputfile);


        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении изображения: " + e.getMessage());
        }
    }
}
