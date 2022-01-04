package fileio;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import pojo.Child;
import service.ChildService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * The class writes the output in files
 */
public class Writer {
    /**
     * The file where the data will be written
     */
    private final FileWriter file;

    public Writer(final String path) throws IOException {
        this.file = new FileWriter(path);
    }

    /**
     * Transforms the output in a JSONObject
     *
     * @param out the file where the result will be written
     * @param array the array containing the results of each round
     * @throws IOException in case of exceptions to reading / writing
     */
    public void writeRound(File out, JArrayRounds array) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(out, array);

    }

    public void addToJSONArray(JArrayRounds arr, JArrayChild arrayChild) {
        arr.getAnnualChildren().add(arrayChild);
    }
}

