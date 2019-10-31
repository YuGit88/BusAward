package com.zz80z.busAward.user.bo;

public class classAndClassDay {
	   private int classId;
	    
		private String classMark;

		private Integer discipline;

	    private Integer health;

	    private Integer teamActivity;

	    private Integer dutyActivity;
	    
	    private String className;
	    
	    private int gradeName;

		public int getClassId() {
			return classId;
		}

		public void setClassId(int classId) {
			this.classId = classId;
		}

		public String getClassMark() {
			return classMark;
		}

		public void setClassMark(String classMark) {
			this.classMark = classMark;
		}

		public Integer getDiscipline() {
			return discipline;
		}

		public void setDiscipline(Integer discipline) {
			this.discipline = discipline;
		}

		public Integer getHealth() {
			return health;
		}

		public void setHealth(Integer health) {
			this.health = health;
		}

		public Integer getTeamActivity() {
			return teamActivity;
		}

		public void setTeamActivity(Integer teamActivity) {
			this.teamActivity = teamActivity;
		}

		public Integer getDutyActivity() {
			return dutyActivity;
		}

		public void setDutyActivity(Integer dutyActivity) {
			this.dutyActivity = dutyActivity;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public int getGradeName() {
			return gradeName;
		}

		public void setGradeName(int gradeName) {
			this.gradeName = gradeName;
		}

		@Override
		public String toString() {
			return "classAndClassDay [classId=" + classId + ", classMark=" + classMark + ", discipline=" + discipline
					+ ", health=" + health + ", teamActivity=" + teamActivity + ", dutyActivity=" + dutyActivity
					+ ", className=" + className + ", gradeName=" + gradeName + "]";
		}
	    
}
