package fileio;

import common.Constants;
import enums.Cities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pojo.Child;
import pojo.Gift;
import util.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    JSONParser jp = new JSONParser();
    ArrayList<AnnualChange> annualChanges = new ArrayList<>();
    ArrayList<Child> children = new ArrayList<>();
    ArrayList<Gift> gifts = new ArrayList<>();
    ArrayList<Cities> cities = new ArrayList<>();
    private final String inputPath;

    /**
     * @param inputPath  The path to the input file
     */
    public Reader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void readData() throws FileNotFoundException {
        try {
            // Parsing the contents of the JSON file
            JSONObject jObj = (JSONObject) jp.parse(new FileReader(inputPath));
            Integer jNumberOfYears = (int) ((long) jObj.get(Constants.NUMBER_OF_YEARS));
            Double jSantaBudget = (double) (long) jObj.get(Constants.SANTA_BUDGET);
            JSONObject jIData = (JSONObject) jObj.get(Constants.INITIAL_DATA);
            JSONArray jChildren = (JSONArray) jIData.get(Constants.CHILDREN);
            JSONArray jGift = (JSONArray) jIData.get(Constants.SANTA_GIFT_LIST);
            JSONArray jAnnualChanges = (JSONArray) jObj.get(Constants.ANNUAL_CHANGES);

            if (jChildren != null) {
                for (Object kid : jChildren) {
                    children.add(new Child.ChildBuilder(
                      (int) (long) ((JSONObject) kid).get(Constants.ID))
                      .withNiceScore((double) (long) ((JSONObject) kid).get(Constants.NICE_SCORE))
                      .withPreference(Utils.convertJSONArrayCategory((JSONArray) ((JSONObject) kid)
                      .get(Constants.GIFTS_PREFERENCES)))
                      .withLastName((String) ((JSONObject) kid).get(Constants.LAST_NAME))
                      .withFirstName((String) ((JSONObject) kid).get(Constants.FIRST_NAME))
                      .withAge((int) (long) ((JSONObject) kid).get(Constants.AGE))
                      .withCity(Utils.toCity((String) ((JSONObject) kid).get(Constants.CITY)))
                      .build());
//                    System.out.println(children.get(children.size()-1));
                }
            }

            if (jGift != null) {
                for (Object toy : jGift) {
                    gifts.add(new Gift((String) ((JSONObject) toy).get(Constants.PRODUCT_NAME),
                            (double) (long) ((JSONObject) toy).get(Constants.PRICE),
                            Utils.toCategory((String) ((JSONObject) toy).get(Constants.CATEGORY))));
                }
            }

            for (Child kid : children) {
                cities.add(kid.getCity());
            }

            InitialData iData = new InitialData((Double) jSantaBudget, children, gifts, cities);

            for (Object change : jAnnualChanges) {
                annualChanges.add(new AnnualChange(
                        (double) (long) ((JSONObject) change).get(Constants.NEW_SANTA_BUDGET),
                        Utils.convertJSONArrayChild((JSONArray) (((JSONObject) change)
                                .get(Constants.NEW_CHILDREN))),
                        Utils.convertJSONArrayChildUpdate((JSONArray) (((JSONObject) change)
                                .get(Constants.CHILDREN_UPDATES))),
                        Utils.convertJSONArrayGift((JSONArray) (((JSONObject) change)
                                .get(Constants.NEW_GIFTS)))
                        ));
            }
            Input in = Input.getINSTANCE(); //create the database (DB)
            in.setAnnualChanges(annualChanges); //populate the DB
            in.setInitialData(iData);
            in.setNumberOfYears(jNumberOfYears);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
