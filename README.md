# RadioButtonSample

## 本題
MainController.ktと、Main.fxmlを中心に話をする。  
- ToggleGroupを作っておくと、ラジオボタンがいい感じになる。  
(グループ内で一つだけ選択できるようになる。)
- グループだけ作って、indexだけでget/setしようと思ったが、  
うまくいかなかったので、fx:idをラジオボタンごとに作成した。

### TextField -> RadioButton
- map1:数字を無理やりRadioButton型にする。  
mapを用意して、ラジオボタンを強引にindex likeに動かした。  
こんな強引な方法をとらなくてもいい気がしている。  
(いい方法ないですかね?)

### RadioButton -> TextField
- 選択したラジオボタンのidを取る方法が分からないので、  
newValueをstring化し、正規表現を用いて、数字を取るという荒業で  
無理やり実装したが、ほかにいい方法があるはずなのでぜひ教えてほしい。
- map2:色情報を取りたかったので、荒業の組み合わせで文字列をColor化して
矩形色を変えている。Castでいけるんじゃない?って思っているが、  
Cast方法さえも分からない。困った。

#### [参考]intellij ideaについて
自分で意識して作ったファイルと、intellij ideaが勝手に作ったものを  
明記しておく。(何も知らないところから、どこをいじると、何か動かせるのか  
差分で理解する。)  
- build.gradle(修正情報は以下の通り。)
- Main.kt 起動はここからやる。

#### [参考]gradle helloworld
build.gradleに、
```
apply plugin: 'application'
mainClassName = 'sample.com.MainApplication'
```
を追加し、Main.ktを呼ぶ。

#### [参考]走らせ方
- IDEでgradleの設定(Edit Configurations..)で以下のように設定  
Name:なんでもいい。(**runとか**)   
```
Gradle Project:RadioButtonSample
Tasks:run
```
- gradlew run(conemuなどを使って、IDE外から走らせる方法)

#### [参考]パス構成
src/main/kotlin/**sample/com(groupがcom.sampleなので)**
にソースを配置するのが「お作法」  
groupがjp.co.exampleなら、example/co/jp配下に置くということです。  
(このあたりはパッケージ名でググってね。私もよくわかっていないので。)
