package vue;

import javax.swing.table.AbstractTableModel;
import controller.Usagercontroller;

public class JTableUsager extends AbstractTableModel {
	

		
		Usagercontroller gestion = new Usagercontroller();
		private static final long serialVersionUID = 1L;
		String[] title = {"ID","Nom","Prenom"};
		//Object[][] data = gestion.lister();

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		

	}
