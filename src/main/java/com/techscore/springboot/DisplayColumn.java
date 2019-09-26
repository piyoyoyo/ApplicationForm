package com.techscore.springboot;

public enum DisplayColumn {
		LAST_NAME("lastName", "お名前（姓）",1),
		FIRST_NAME("firstName", "お名前（名）",2),
		LAST_NAME_KANA("lastNameKana", "お名前（セイ）",3),
		FIRT_NAME_KANA("firstNameKana", "お名前（メイ）",4),
		ZIP_CODE("zipcode", "郵便番号",5),
		PREF_ID("pref_id", "都道府県",6),
		CITY("city", "市区群",7),
		TOWN("town", "町名",8),
		HOUSE_NUM("house_num", "番地",9),
		BUILDING("building", "建物名",10),
		PHONE("phone", "電話番号",11);

	    private String fieldId;
	    private String displayName;
	    private int sort;

	    private DisplayColumn(String fieldId, String displayName, int sort) {
	        this.fieldId = fieldId;
	        this.displayName = displayName;
	        this.sort = sort;
	    }

		public String getFieldId() {
			return fieldId;
		}

		public String getDisplayName() {
			return displayName;
		}

		public int getSort() {
			return sort;
		}

	    public static DisplayColumn getByFieldId(String fieldId) {
	        for (DisplayColumn displayColumn : DisplayColumn.values()) {
	            if (displayColumn.getFieldId().equals(fieldId)) {
	                return displayColumn;
	            }
	        }
	        return null;
	    }


}
