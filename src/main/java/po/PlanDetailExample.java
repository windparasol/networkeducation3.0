package po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PlanDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPdIdIsNull() {
            addCriterion("pd_id is null");
            return (Criteria) this;
        }

        public Criteria andPdIdIsNotNull() {
            addCriterion("pd_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdIdEqualTo(Integer value) {
            addCriterion("pd_id =", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotEqualTo(Integer value) {
            addCriterion("pd_id <>", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThan(Integer value) {
            addCriterion("pd_id >", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_id >=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThan(Integer value) {
            addCriterion("pd_id <", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdLessThanOrEqualTo(Integer value) {
            addCriterion("pd_id <=", value, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdIn(List<Integer> values) {
            addCriterion("pd_id in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotIn(List<Integer> values) {
            addCriterion("pd_id not in", values, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdBetween(Integer value1, Integer value2) {
            addCriterion("pd_id between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andPdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_id not between", value1, value2, "pdId");
            return (Criteria) this;
        }

        public Criteria andCpIdIsNull() {
            addCriterion("cp_id is null");
            return (Criteria) this;
        }

        public Criteria andCpIdIsNotNull() {
            addCriterion("cp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCpIdEqualTo(Integer value) {
            addCriterion("cp_id =", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotEqualTo(Integer value) {
            addCriterion("cp_id <>", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThan(Integer value) {
            addCriterion("cp_id >", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cp_id >=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThan(Integer value) {
            addCriterion("cp_id <", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThanOrEqualTo(Integer value) {
            addCriterion("cp_id <=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdIn(List<Integer> values) {
            addCriterion("cp_id in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotIn(List<Integer> values) {
            addCriterion("cp_id not in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdBetween(Integer value1, Integer value2) {
            addCriterion("cp_id between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cp_id not between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpTypeIsNull() {
            addCriterion("cp_type is null");
            return (Criteria) this;
        }

        public Criteria andCpTypeIsNotNull() {
            addCriterion("cp_type is not null");
            return (Criteria) this;
        }

        public Criteria andCpTypeEqualTo(String value) {
            addCriterion("cp_type =", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeNotEqualTo(String value) {
            addCriterion("cp_type <>", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeGreaterThan(String value) {
            addCriterion("cp_type >", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cp_type >=", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeLessThan(String value) {
            addCriterion("cp_type <", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeLessThanOrEqualTo(String value) {
            addCriterion("cp_type <=", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeLike(String value) {
            addCriterion("cp_type like", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeNotLike(String value) {
            addCriterion("cp_type not like", value, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeIn(List<String> values) {
            addCriterion("cp_type in", values, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeNotIn(List<String> values) {
            addCriterion("cp_type not in", values, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeBetween(String value1, String value2) {
            addCriterion("cp_type between", value1, value2, "cpType");
            return (Criteria) this;
        }

        public Criteria andCpTypeNotBetween(String value1, String value2) {
            addCriterion("cp_type not between", value1, value2, "cpType");
            return (Criteria) this;
        }

        public Criteria andReplyTextIsNull() {
            addCriterion("reply_text is null");
            return (Criteria) this;
        }

        public Criteria andReplyTextIsNotNull() {
            addCriterion("reply_text is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTextEqualTo(String value) {
            addCriterion("reply_text =", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotEqualTo(String value) {
            addCriterion("reply_text <>", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextGreaterThan(String value) {
            addCriterion("reply_text >", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextGreaterThanOrEqualTo(String value) {
            addCriterion("reply_text >=", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLessThan(String value) {
            addCriterion("reply_text <", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLessThanOrEqualTo(String value) {
            addCriterion("reply_text <=", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLike(String value) {
            addCriterion("reply_text like", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotLike(String value) {
            addCriterion("reply_text not like", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextIn(List<String> values) {
            addCriterion("reply_text in", values, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotIn(List<String> values) {
            addCriterion("reply_text not in", values, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextBetween(String value1, String value2) {
            addCriterion("reply_text between", value1, value2, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotBetween(String value1, String value2) {
            addCriterion("reply_text not between", value1, value2, "replyText");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlIsNull() {
            addCriterion("annex_url is null");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlIsNotNull() {
            addCriterion("annex_url is not null");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlEqualTo(String value) {
            addCriterion("annex_url =", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlNotEqualTo(String value) {
            addCriterion("annex_url <>", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlGreaterThan(String value) {
            addCriterion("annex_url >", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlGreaterThanOrEqualTo(String value) {
            addCriterion("annex_url >=", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlLessThan(String value) {
            addCriterion("annex_url <", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlLessThanOrEqualTo(String value) {
            addCriterion("annex_url <=", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlLike(String value) {
            addCriterion("annex_url like", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlNotLike(String value) {
            addCriterion("annex_url not like", value, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlIn(List<String> values) {
            addCriterion("annex_url in", values, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlNotIn(List<String> values) {
            addCriterion("annex_url not in", values, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlBetween(String value1, String value2) {
            addCriterion("annex_url between", value1, value2, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andAnnexUrlNotBetween(String value1, String value2) {
            addCriterion("annex_url not between", value1, value2, "annexUrl");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStimeIsNull() {
            addCriterion("stime is null");
            return (Criteria) this;
        }

        public Criteria andStimeIsNotNull() {
            addCriterion("stime is not null");
            return (Criteria) this;
        }

        public Criteria andStimeEqualTo(Date value) {
            addCriterionForJDBCDate("stime =", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("stime <>", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThan(Date value) {
            addCriterionForJDBCDate("stime >", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stime >=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThan(Date value) {
            addCriterionForJDBCDate("stime <", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stime <=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeIn(List<Date> values) {
            addCriterionForJDBCDate("stime in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("stime not in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stime between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stime not between", value1, value2, "stime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}