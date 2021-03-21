package com.random.vikas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class ReportingDemo {
	
	public static void main(String[] args) {
		DownloadRequest request = new DownloadRequest();
		request.setId("123");
		List<QueryParam> qParamList = new ArrayList<>();
		List<DataSet> dSetList = new ArrayList<>();
		QueryParam qparam1 = new QueryParam();
		qparam1.setKey("HeaderParam");
		DataSet dset1 = new DataSet();
		dset1.setKey("employee_id");
		dset1.setValue("456");
		dSetList.add(dset1);
		DataSet dset2 = new DataSet();
		dset2.setKey("employee_name");
		dset2.setValue("Vikas");
		dSetList.add(dset2);
		qparam1.setValue(dSetList);
		qParamList.add(qparam1);
		request.setQueryParam(qParamList);
		String query = "select * from employee emp where emp.name in ({emp_name})";
		String mappingString = "{\r\n" + 
				"	\"employee_id\": \"emp_id\",\r\n" + 
				"	\"employee_name\": \"emp_name\",\r\n" + 
				"	\"ed\": \"emp_dept\"\r\n" + 
				"}";
		Map<String, String> columnMap = convertMappingStringToMap(mappingString);
		String updatedQuery = createQuery(request, query, columnMap);
		System.out.println(updatedQuery);
	}

	private static Map<String, String> convertMappingStringToMap(String mappingString) {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<HashMap<String,String>> typeRef = new TypeReference<HashMap<String,String>>() {};
		Map<String, String> columnMap = null;
		try {
			columnMap = mapper.readValue(mappingString, typeRef);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return columnMap;
	}

	private static String createQuery(DownloadRequest request, String query, Map<String, String> columnMap) {
		StringBuilder builder = new StringBuilder(query);
		request.getQueryParam().stream().forEach(queryParam -> {
			queryParam.getValue().stream().forEach(dataSet -> {
				if (columnMap.get(dataSet.getKey()) != null 
						&& query.contains(columnMap.get(dataSet.getKey()))
						&& query.indexOf(columnMap.get(dataSet.getKey())) != -1) {
					int startIndex = query.indexOf(columnMap.get(dataSet.getKey())) - 1;
					int endIndex = query.indexOf(columnMap.get(dataSet.getKey())) + columnMap.get(dataSet.getKey()).length() + 1;
					builder.replace(startIndex, endIndex, dataSet.getValue());
				}
			});
		});
		return builder.toString();
	}

}
