package po;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassRoomExample() {
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

        public Criteria andRoIdIsNull() {
            addCriterion("ro_id is null");
            return (Criteria) this;
        }

        public Criteria andRoIdIsNotNull() {
            addCriterion("ro_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoIdEqualTo(Integer value) {
            addCriterion("ro_id =", value, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdNotEqualTo(Integer value) {
            addCriterion("ro_id <>", value, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdGreaterThan(Integer value) {
            addCriterion("ro_id >", value, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ro_id >=", value, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdLessThan(Integer value) {
            addCriterion("ro_id <", value, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdLessThanOrEqualTo(Integer value) {
            addCriterion("ro_id <=", value, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdIn(List<Integer> values) {
            addCriterion("ro_id in", values, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdNotIn(List<Integer> values) {
            addCriterion("ro_id not in", values, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdBetween(Integer value1, Integer value2) {
            addCriterion("ro_id between", value1, value2, "roId");
            return (Criteria) this;
        }

        public Criteria andRoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ro_id not between", value1, value2, "roId");
            return (Criteria) this;
        }

        public Criteria andTcIdIsNull() {
            addCriterion("tc_id is null");
            return (Criteria) this;
        }

        public Criteria andTcIdIsNotNull() {
            addCriterion("tc_id is not null");
            return (Criteria) this;
        }

        public Criteria andTcIdEqualTo(Integer value) {
            addCriterion("tc_id =", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdNotEqualTo(Integer value) {
            addCriterion("tc_id <>", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdGreaterThan(Integer value) {
            addCriterion("tc_id >", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tc_id >=", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdLessThan(Integer value) {
            addCriterion("tc_id <", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdLessThanOrEqualTo(Integer value) {
            addCriterion("tc_id <=", value, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdIn(List<Integer> values) {
            addCriterion("tc_id in", values, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdNotIn(List<Integer> values) {
            addCriterion("tc_id not in", values, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdBetween(Integer value1, Integer value2) {
            addCriterion("tc_id between", value1, value2, "tcId");
            return (Criteria) this;
        }

        public Criteria andTcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tc_id not between", value1, value2, "tcId");
            return (Criteria) this;
        }

        public Criteria andRoomnameIsNull() {
            addCriterion("roomname is null");
            return (Criteria) this;
        }

        public Criteria andRoomnameIsNotNull() {
            addCriterion("roomname is not null");
            return (Criteria) this;
        }

        public Criteria andRoomnameEqualTo(String value) {
            addCriterion("roomname =", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotEqualTo(String value) {
            addCriterion("roomname <>", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThan(String value) {
            addCriterion("roomname >", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameGreaterThanOrEqualTo(String value) {
            addCriterion("roomname >=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThan(String value) {
            addCriterion("roomname <", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLessThanOrEqualTo(String value) {
            addCriterion("roomname <=", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameLike(String value) {
            addCriterion("roomname like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotLike(String value) {
            addCriterion("roomname not like", value, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameIn(List<String> values) {
            addCriterion("roomname in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotIn(List<String> values) {
            addCriterion("roomname not in", values, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameBetween(String value1, String value2) {
            addCriterion("roomname between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomnameNotBetween(String value1, String value2) {
            addCriterion("roomname not between", value1, value2, "roomname");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleIsNull() {
            addCriterion("roomdescrible is null");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleIsNotNull() {
            addCriterion("roomdescrible is not null");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleEqualTo(String value) {
            addCriterion("roomdescrible =", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleNotEqualTo(String value) {
            addCriterion("roomdescrible <>", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleGreaterThan(String value) {
            addCriterion("roomdescrible >", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleGreaterThanOrEqualTo(String value) {
            addCriterion("roomdescrible >=", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleLessThan(String value) {
            addCriterion("roomdescrible <", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleLessThanOrEqualTo(String value) {
            addCriterion("roomdescrible <=", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleLike(String value) {
            addCriterion("roomdescrible like", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleNotLike(String value) {
            addCriterion("roomdescrible not like", value, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleIn(List<String> values) {
            addCriterion("roomdescrible in", values, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleNotIn(List<String> values) {
            addCriterion("roomdescrible not in", values, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleBetween(String value1, String value2) {
            addCriterion("roomdescrible between", value1, value2, "roomdescrible");
            return (Criteria) this;
        }

        public Criteria andRoomdescribleNotBetween(String value1, String value2) {
            addCriterion("roomdescrible not between", value1, value2, "roomdescrible");
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