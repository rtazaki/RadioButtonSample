package sample.com

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.stage.Stage
import javafx.scene.Scene

class MainApplication : Application() {
    override fun start(stage: Stage) {
        val parent = FXMLLoader.load<Parent>(javaClass.getResource("/fxml/Main.fxml"))
        val scane = Scene(parent)
        stage.title = "ラジオボタンの設定"
        stage.scene = scane
        stage.show()
    }
}
