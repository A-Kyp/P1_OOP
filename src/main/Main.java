package main;

import checker.Checker;
import common.Constants;
import fileio.Input;
import fileio.PreChecker;
import fileio.Reader;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException, ParseException {
        File directory = new File(Constants.TESTS_PATH); //path to the tests folder
        Path path = Paths.get(Constants.RESULT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File(Constants.RESULT_PATH);
        PreChecker.deleteFiles(outputDirectory.listFiles());

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = Constants.OUT_PATH + file.getName();
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getAbsolutePath(), filepath);
            }
        }

        Checker.calculateScore();

    }

    /**
     * @param inFile input file
     * @param outFile output file
     */
    public static void action(final String inFile, final String outFile) throws FileNotFoundException {
        Reader read = new Reader(inFile);
        Input in = Input.getINSTANCE(); //the DB

        read.readData();

    }
}
