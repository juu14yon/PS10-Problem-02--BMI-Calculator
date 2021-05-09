import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class BMICalculatorController {
    @FXML private RadioButton unitsMetricRadioButton;
    @FXML private ToggleGroup metricSystemRadioGroup;
    @FXML private RadioButton unitsEnglishRadioButton;
    @FXML private TextField weightTextField;
    @FXML private TextField heightTextField;
    @FXML private Button calculateButton;
    @FXML private TextField resultBMITextField;

    @FXML
    void calculatorButtonPressed(ActionEvent event) {
        try{
            double weight = Double.parseDouble(weightTextField.getText());
            while(weight<0.0){
                invalidWeight();
                weight = Double.parseDouble(weightTextField.getText());
            }
            try {
                double height = Double.parseDouble(heightTextField.getText());
                while(height<0.0){
                    invalidHeight();
                    height = Double.parseDouble(heightTextField.getText());
                }
                boolean metric = unitsMetricRadioButton.isSelected();
                double resultBMI = weight / (height * height);

                if (!metric){
                    resultBMI *=703;
                }
                resultBMITextField.setText(""+ resultBMI);
            }
            catch (NumberFormatException ex){
                invalidHeight();
            }

        }
        catch (NumberFormatException ex){
            invalidWeight();
        }
    }

    void invalidWeight(){
        weightTextField.setText("Invalid input");
        weightTextField.selectAll();
        weightTextField.requestFocus();
    }

    void invalidHeight(){
        heightTextField.setText("Invalid input");
        heightTextField.selectAll();
        heightTextField.requestFocus();
    }

}