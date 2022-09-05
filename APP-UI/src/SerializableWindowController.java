import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.TextField;


public class SerializableWindowController  implements Initializable{
    
    Conection conexion  = new Conection();

    @FXML
    private TableColumn<Curso, String> Creditos;

    @FXML
    private TableColumn<Curso, String> Curso;

    @FXML
    private TableColumn<Curso, Integer> ID;

    @FXML
    private TableColumn<Curso, String> Nombre;

    @FXML
    private AnchorPane Serializable_window;

    @FXML
    private Button btn_agregar;
    @FXML
    private Button btnSerializable_Rollback;

    @FXML


   //---------------- Buttons -------------------------------------------------
 
    private Button btnSerializable_commit;
    
      @FXML
    private Button btn_inicarTrasaccion;
      
      @FXML
    private Button btn_actualizar;
      
         //---------------- TABLE -------------------------------------------------
    @FXML
    private TableView<Curso> tbl_Serializable;
    public static ObservableList<Curso> table_curso;

    //------------- TXT -----------------------------------------------------
    
    @FXML
    private TextField txt_creditos;

    @FXML
    private TextField txt_curso;

    @FXML
    private TextField txt_nombre;
    
    //----------------PROCEDURES ---------------------------------------
    @FXML
    void executeQSL(ActionEvent btn_agregar) {
          this.insert_Curso();
          this.loadCurso();
    }
    
       @FXML
    void Init_Transaction(ActionEvent event) {
           System.out.println("Inicar trasaccion");
           conexion.ejecutarSenctenciaSQL("start transaction");
    }
    

    @FXML
    void Actualizar(ActionEvent event) {
       this.loadCurso();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
         this.loadCurso();
      
        Nombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        Creditos.setCellValueFactory(new PropertyValueFactory<>("credits")); 
        Curso.setCellValueFactory(new PropertyValueFactory<>("assignature")); 
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
         
    }
    
    public void loadCurso(){
        table_curso = FXCollections.observableArrayList();
        try{
           
               ResultSet resultado = conexion.consultarRegistros("select * from curso");
               
               while(resultado.next()){
                   table_curso.add(new Curso(resultado.getString("docente"),resultado.getString("nombre"),resultado.getString("creditos"),resultado.getInt("id")));
                   
               }
        }catch(SQLException e){
            
        }
        
        tbl_Serializable.setItems(table_curso);
    }
    
        @FXML
    void TransactionCommit(ActionEvent event) {
            System.out.println("Se comiteo la transaccion");
          
            conexion.ejecutarSenctenciaSQL("commit");
    }

    @FXML
    void Transaction_Rollback(ActionEvent event) {
        System.out.println("Se ejecuto el rollback");
      
        conexion.ejecutarSenctenciaSQL("rollback");

    }
    
    private void insert_Curso(){
        
        String sentenciaSQL = String.format("INSERT INTO Curso (nombre,docente,creditos)"+"values ('%S','%S','%S')",
                this.txt_curso.getText(),this.txt_nombre.getText(),this.txt_creditos.getText());
        
        conexion.ejecutarSenctenciaSQL(sentenciaSQL);
    }
    
    
   

}