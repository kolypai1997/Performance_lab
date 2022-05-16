package task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class task3 {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		// TODO Auto-generated method stub
		try {
			FileReader readerTests = new FileReader(args[0]);
			FileReader readerVal = new FileReader(args[1]);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(readerTests);// ������� �� tests.json
			JSONObject jsonObjectVal = (JSONObject) jsonParser.parse(readerVal);// ������� �� values.json
			// ��������� ������� ������
			JSONArray tests = (JSONArray) jsonObject.get("tests");// ����� ������ �������� �� ������
			// ��������� ������� values
			JSONArray values = (JSONArray) jsonObjectVal.get("values");
			// ���� �� ����� ����� ����������� ����� 4 ������?
			// ����� �������� �������
			for (int i = 0; i < tests.size(); i++) {
				JSONObject objectTests = (JSONObject) tests.get(i);// 1 ������� ��������
				for (Object o : values) {
					JSONObject obj = (JSONObject) o;
					if ((long) objectTests.get("id") == (long) obj.get("id")) {
						objectTests.put("value", obj.get("value"));
					}
				}
				if (objectTests.get("values") != null) {
					JSONArray valuesArray = (JSONArray) objectTests.get("values");
					for (int j = 0; j < valuesArray.size(); j++) {// 2 �������
						JSONObject objectValuesArray = (JSONObject) valuesArray.get(j);
						for (Object o : values) {
							JSONObject obj = (JSONObject) o;
							if ((long) objectValuesArray.get("id") == (long) obj.get("id")) {
								objectValuesArray.put("value", obj.get("value"));
							}
						}
						if (objectValuesArray.get("values") != null) {// 3 �������
							JSONArray valuesArray3 = (JSONArray) objectValuesArray.get("values");
							for (int k = 0; k < valuesArray3.size(); k++) {
								JSONObject objectValuesArray3 = (JSONObject) valuesArray3.get(k);
								for (Object o : values) {
									JSONObject obj = (JSONObject) o;
									if ((long) objectValuesArray3.get("id") == (long) obj.get("id")) {
										objectValuesArray3.put("value", obj.get("value"));
									}
								}
								if (objectValuesArray3.get("values") != null) {// 4 lvl
									JSONArray valuesArray4 = (JSONArray) objectValuesArray3.get("values");
									for (int h = 0; h < valuesArray4.size(); h++) {
										JSONObject objectValuesArray4 = (JSONObject) valuesArray4.get(h);
										for (Object o : values) {
											JSONObject obj = (JSONObject) o;
											if ((long) objectValuesArray4.get("id") == (long) obj.get("id")) {
												objectValuesArray4.put("value", obj.get("value"));
											}
										}
									}
								}

							}
						}
					}
				}
			}
			FileWriter output = new FileWriter("report.json");
			output.write(tests.toJSONString());
			output.flush();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

}
