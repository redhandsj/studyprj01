//  
//  Excel����
//  
//  �@Excel�̋N���ƏI���B
//  
/****************************************************************************
 * �O���[�o���I�u�W�F�N�g�擾
 ***************************************************************************/
// WSH�I�u�W�F�N�g
var wsh = new ActiveXObject("WScript.Shell");
// Excel�I�u�W�F�N�g���擾(Excel�̋N��)
var ExcelApp = new ActiveXObject( "Excel.Application" );
// �A�v���P�[�V����Shell
var objShell = WScript.CreateObject("Shell.Application")

/****************************************************************************
 * �G�N�Z���J�n �� �I��
 ***************************************************************************/
function excel_start()
{
	//  Excel�A�v���P�[�V������\��
	ExcelApp.Visible = true;

	//  �V�����u�b�N��ǉ����A1�V�[�g�ڂ��擾
	var book = ExcelApp.Workbooks.Add();
	var sheet = book.Worksheets( 1 );

	//  �Z���ɒl��ݒ�
	sheet.Range( "A1" ).Value = "��";
	sheet.Cells(4, 3).Value = "��";
	WScript.Sleep( 1000 );

	//  A1�̃Z���̒l�����b�Z�[�W�{�b�N�X�ŕ\��
	WScript.Echo( "A1=" + sheet.Range("A1").Value );
	//  �w�i�F��ԐF�ɐݒ�
	ExcelApp.Range( "A1" ).Interior.ColorIndex = 3
	WScript.Sleep( 1000 );

	//  �s��4�A��3�̃Z���̒l�����b�Z�[�W�{�b�N�X�ŕ\��
	WScript.Echo( "�s4, ��3=" + sheet.Cells(4, 3).Value );
	WScript.Sleep( 1000 );

	//  Excel�֐���Sum�֐����Ăяo��
	var anser = ExcelApp.WorksheetFunction.Sum( 10, 5, 8 );
	WScript.Echo( "10 + 5 + 8 = " + anser );
	WScript.Sleep( 1000 );

	// ������xlsx�t�@�C�����J��
	//var book = ExcelApp.Workbooks.Open("G:/repos/svn/crnwl/E_�����E�P�̃e�X�g/E04_�P�̃e�X�g�d�l�����ʕ񍐏�/02_�����z�M���/01_�o�b�`�@�\�݌v(�풓)/03_�e�X�g�f�[�^/�����z�M��Ք��f/�y�X�܁z�f�ڒ�~/�y�X�܁z�f�ڒ�~_�f�[�^�p�^�[��.xlsx");
	//WScript.Sleep( 1000 );

	//  �u�b�N�����
	//book.Close(true);   // �ۑ�����
	book.Close(false);  // �ۑ����Ȃ�

	//  Excel���I��
	ExcelApp.Quit();
	WScript.Echo("�I��");
	//  �I�u�W�F�N�g�����
	ExcelApp = null;
}

/****************************************************************************
 * �t�H���_�I���_�C�A���O
 ***************************************************************************/
function selectdir() {
	var folder = objShell.BrowseForFolder(0, "�t�H���_�I��", 0);
	if (folder == null) return;
	var path = folder.Self.Path;
	return path;
}


/****************************************************************************
 * �t�@�C���I���_�C�A���O
 ***************************************************************************/
function selectfile()
{
	var tmpFileName = objShell..GetOpenFilename(
		FileFilter:="�G�N�Z���t�@�C��(*.xlsx),*.xlsx", FilterIndex:=1,
		Title:="�f�t�H���g�f�[�^�e���v���[�g", MultiSelect:=False);

//	var dialog = WScript.CreateObject("InternetExplorer.Application");
//	dialog.Filter = "Text Files|*.txt|Csv Files|*.csv|All Files|*.*";
//	dialog.InitialDir = ".";
//	if (!dialog.ShowOpen()) {
//		WScript.Echo("�t�@�C���͑I������Ȃ������݂������c�c�B");
//		WScript.Quit();
//	}
	WScript.Echo("�I�������̂͂��ꂩ�H\n\"" + tmpFileName + "\"");
}

/****************************************************************************
 * @ ���s
 ***************************************************************************/
// �t�@�C���I���_�C�A���O
selectfile();
// �t�H���_�I���_�C�A���O
//WScript.Echo(selectdir());
// �G�N�Z���J�n
//excel_start();


