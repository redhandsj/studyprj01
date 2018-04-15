'//スクリプトエンジンのバージョンを確認してみる
Function pub_ShowVersion
	MsgBox "Version: " & ScriptEngineMajorVersion &_
		"." & ScriptEngineMinorVersion
End Function

pub_ShowVersion
