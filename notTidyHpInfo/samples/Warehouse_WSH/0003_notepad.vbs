Set objShell = WScript.CreateObject("WScript.Shell")
objShell.Run "notepad.exe test.txt"
WScript.Sleep 1000
objShell.SendKeys "^f"      ' Ctrl+Fで検索ダイアログの表示
WScript.Sleep 100
objShell.SendKeys "WSH~"    ' WSHと入力してEnterキーを押す
objShell.SendKeys "{ESC}"   ' ダイアログを閉じる
WScript.Sleep 100
objShell.SendKeys "{HOME}"  ' 行頭に戻る
objShell.SendKeys "+{END}"  ' Shift+End で行末まで選択
objShell.SendKeys "^c"      ' Ctrl+Cでコピー
objShell.SendKeys "%{F4}"   ' Alt+F4で終了


