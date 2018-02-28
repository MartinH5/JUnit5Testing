# JUnit5Testing


Kode til compare:

	@Override
    public void sortByName(ArrayList<PersonImpl> persons) {
        
	Collections.sort(list, new Comparator<PersonImpl>() {
    @Override
      public int compare(final PersonImpl p1, final PersonImpl p2) {
          return p1.getName().compareTo(p2.getName());
     }
  });
}
