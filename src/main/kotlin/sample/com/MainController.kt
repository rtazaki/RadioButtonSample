package sample.com

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ChoiceBox
import javafx.scene.control.RadioButton
import javafx.scene.control.TextField
import javafx.scene.control.ToggleGroup
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import java.net.URL
import java.util.*

class MainController : Initializable {
    @FXML
    lateinit var rgbColorGroup: ToggleGroup
    @FXML
    lateinit var rgbIndexField: TextField
    @FXML
    lateinit var rgbResultRectangle: Rectangle

    // id指定の部分が冗長なので何とかしたい。
    @FXML
    lateinit var rgbColor0: RadioButton
    @FXML
    lateinit var rgbColor1: RadioButton
    @FXML
    lateinit var rgbColor2: RadioButton

    @FXML
    lateinit var rgbChoice: ChoiceBox<String>

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        // TextField -> RadioButton
        // idをindexのように使うためのMap
        val map1 = mapOf(0 to rgbColor0, 1 to rgbColor1, 2 to rgbColor2)
        rgbIndexField.textProperty().addListener { _, _, newValue ->
            try {
                if (newValue.toInt() < 3) {
                    println("TextField: $newValue")
                    rgbColorGroup.selectToggle(map1[newValue.toInt()])
                    rgbChoice.selectionModel.select(newValue.toInt())
                }
            } catch (exception: NumberFormatException) {
                // 数字以外の入力は無視
            }
        }
        // RadioButton -> TextField
        // Red→Color.REDにする
        val map2 = mapOf("Red" to Color.RED, "Blue" to Color.BLUE, "Green" to Color.GREEN)
        rgbColorGroup.selectedToggleProperty().addListener { _, _, newValue ->
            println(newValue)
            // 選択したラジオボタンのidを拾うための、間違った方向の努力
            val id = Regex("""id=[^,]+""")
            rgbIndexField.text = id.find(newValue.toString())?.value?.last().toString()
            // 色変えするための、これまた間違った努力
            val color = Regex("""'[^']+""")
            val colorstr = color.find(newValue.toString())?.value?.replace("'", "")
            rgbResultRectangle.fill = map2[colorstr]
        }
        // ChoiceBox -> TextField
        rgbChoice.items.addAll("赤", "緑", "青")
        rgbChoice.selectionModel.selectedIndexProperty().addListener { _, _, newValue ->
            println("ChoiceBox: $newValue")
            rgbIndexField.text = newValue.toString()
        }
    }
}