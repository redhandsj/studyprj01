//  
//  ���̃v���O�����̎��s�Ȃ�


/****************************************************************************
 * �O���[�o���I�u�W�F�N�g�擾
 ***************************************************************************/
var wsh = new ActiveXObject("WScript.Shell");

/****************************************************************************
 * �N��
 ***************************************************************************/
function withExecCommand(cmd, func) {
	var exec = wsh.exec(cmd);
	while (!exec.StdOut.AtEndOfStream) {
		func(exec.StdOut.ReadLine());
	}
	return exec.ExitCode;
}
function execCommand(cmd) {
	return withExecCommand(cmd, function (line) { WScript.Echo(line);});
}
/****************************************************************************
 * @ ���s
 ***************************************************************************/
// �R�}���h�N��
execCommand("cmd /C dir");



