package com.test.queryPasing;

public enum XML {
	COMMENT("<!--","</>")
	,META1("<?","</>")
	,META2("<!DOCTYPE","</>")
	,MAPPER("<mapper","</mapper>")
	,SELECT("<select","</select>")
	,INSERT("<insert","</insert>")
	,UPDATE("<update","</update>")
	,IF("<if","</if>")
	,SQL("<sql","</sql>")
	,RESULT("<result","</>")
	,RESULTMAP("<resultMap","</resultMap>")
	,ID("<id","</>")
	,CHOOSE("<choose","</choose>")
	,WHEN("<when","</when>")
	,OTHERWISE("<otherwise","</otherwise>")
	,FOREACH("<foreach","</foreach>")
	;
	private String start;
	private String end;
	public static XML[] SKIP = new XML[] {COMMENT,META1,META2,MAPPER,SQL,ID};
	public static boolean skip(String line) {
		boolean flag = false;
		for (XML xml : SKIP) {
			if(line.startsWith(xml.start)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	private XML(String start,String end) {
		this.start= start;
		this.end= end;
	}
	
}
