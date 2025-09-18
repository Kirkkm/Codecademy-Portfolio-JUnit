public interface IItem {
        public String getName();
        public String getDescription();
        public String getType();
        public int getQuantity();
        public void addItem(int quantity);
        public void removeItem(int quantity);
}
