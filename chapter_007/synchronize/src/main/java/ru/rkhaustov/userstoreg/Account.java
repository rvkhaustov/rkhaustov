package ru.rkhaustov.userstoreg;

/**
 * Created by rvkha_000 on 16.06.2017.
 */
    public class Account {
        /**
         * amount.
         */
        private float amount = 0f;
        /**
         * requisites.
         */
        private String requisites;

        /**
         * @param value set value
         */
        public void setAmount(float value) {
            this.amount = value;
        }

        /**
         * @param requisites  requisites
         */
        public void setRequisites(String requisites) {
            this.requisites = requisites;
        }

        /**
         * @return getvalue
         */
        public float getAmount() {
            return this.amount;
        }

        /**
         * @return getRequisites
         */
        public String getRequisites() {
            return requisites;
        }

        /**
         * @param requisites requisites
         * @param amount amount
         */
        public Account(String requisites, float amount) {
            this.amount = amount;
            this.requisites = requisites;
        }

        /**
         * @param requisites requisites
         */
        public Account(String requisites) {
            this.requisites = requisites;
        }

        /**
         * @return toString
         */
        @Override
        public String toString() {
            return String.format("requisites=%s, value=%s", requisites, amount);
        }

        /**
         * @param o Account
         * @return false true
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Account account = (Account) o;

            return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
        }

        /**
         * @return hashCode
         */
        @Override
        public int hashCode() {
            return requisites != null ? requisites.hashCode() : 0;
        }
    }

