Set objShell = WScript.CreateObject("WScript.Shell")
objShell.Run "notepad.exe test.txt"
WScript.Sleep 1000
objShell.SendKeys "^f"      ' Ctrl+F�Ō����_�C�A���O�̕\��
WScript.Sleep 100
objShell.SendKeys "WSH~"    ' WSH�Ɠ��͂���Enter�L�[������
objShell.SendKeys "{ESC}"   ' �_�C�A���O�����
WScript.Sleep 100
objShell.SendKeys "{HOME}"  ' �s���ɖ߂�
objShell.SendKeys "+{END}"  ' Shift+End �ōs���܂őI��
objShell.SendKeys "^c"      ' Ctrl+C�ŃR�s�[
objShell.SendKeys "%{F4}"   ' Alt+F4�ŏI��


