/****************************************************************************
 * �e�X�g�f�[�^�쐬�c�[��
 ***************************************************************************/

/****************************************************************************
 * �O���[�o���萔�iIE�ł�const�͖���`�Ȃ̂ŁA�d���Ȃ�var���g���j
 ***************************************************************************/
/** DB�d�l����`�F�e�[�u���ꗗ�V�[�g */
var CST_DB_SHIYOSYO_TBLLIST = "�e�[�u���ꗗ"; // �e�[�u���ꗗ�V�[�g��
var CST_DB_SHIYOSYO_TBLLIST_R_X = 4;		// �e�[�u���ꗗ�̘_������
var CST_DB_SHIYOSYO_TBLLIST_B_X = 5;		// �e�[�u���ꗗ�̕�������
var CST_DB_SHIYOSYO_TBLLIST_START_Y = 4; 	// �e�[�u���ꗗ�̊J�n�s
/** DB�d�l����`�F�����e�[�u���V�[�g */
var CST_DB_SHIYOSYO_TBLS_CM_B_X = 3; 		// �e�[�u���J������������
var CST_DB_SHIYOSYO_TBLS_CM_B_START_Y = 8; 	// �e�[�u���J�����������J�n�s
/** �f�t�H���g�l�̃��R�[�h�� */
var CST_DEF_DATA_CNT = 50; 	


/****************************************************************************
 * �O���[�o���I�u�W�F�N�g
 ***************************************************************************/
// WSH�I�u�W�F�N�g
var wsh = new ActiveXObject("WScript.Shell");
// Excel�I�u�W�F�N�g���擾(Excel�̋N��)
var ExcelApp = new ActiveXObject( "Excel.Application" );
// �A�v���P�[�V����Shell
var objShell = WScript.CreateObject("Shell.Application")
//  ���O�t�@�C���֘A�̑����񋟂���I�u�W�F�N�g���擾
var fs = new ActiveXObject( "Scripting.FileSystemObject" );
var logfile = fs.OpenTextFile( 
	("LOG"+comDateFormat(new Date(), "yyyyMMddHHmmssfff")+".txt"), 2, true );
// DB�d�l���I�u�W�F�N�g
var dbSpecificationsBook = null;


/****************************************************************************
 * @ ���s�|�C���g
 ***************************************************************************/
function main()
{
	try
	{
		/** Excel�A�v���P�[�V������\�� */
		ExcelApp.Visible = true;
		// �t�@�C���I���_�C�A���O
		var tempfile = selectfile("�G�N�Z���t�@�C��(*.xlsm),*.xlsm","DB�d�l���I��");
		// DB�݌v���e���v���[�g
		wlog("�t�@�C���擾");
	    if(tempfile==false){
			WScript.Echo("�t�@�C���͑I������Ȃ������݂������c�c�B");
			return;
	    }
		// �e���v���[�g�t�@�C���쐬
		MakeTemplate_FromDBspecs(tempfile);
		wlog("�t�@�C���擾");
		// �t�H���_�I���_�C�A���O
		//WScript.Echo(selectdir());
		// �G�N�Z���J�n
		//excel_start();
	} catch( e ) {
		alert( e );  // �o�O�̓��e���_�C�A���O�ŕ\������
	}finally{
		// ���O�t�@�C����n��
		wlog("PROC END");
		logfile.Close();
		logfile = null;
		//  Excel���I��
		ExcelApp.Quit();
		wlog("PROC END");
		//  �I�u�W�F�N�g�����
		ExcelApp = null;
	}
}
main();


/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// �� �������火�́A�r�W�l�X���W�b�N
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

/****************************************************************************
 * �e���v���[�g�t�@�C���쐬
 * @param tile DB�d�l���t�@�C���p�X
 ***************************************************************************/
function MakeTemplate_FromDBspecs(file)
{
	try
	{
		wlog("MakeTemplate_FromDBspecs() -> " + file);

		/** DB�d�l���̃I�u�W�F�N�g�擾 */
		var dbSpecBook = ExcelApp.Workbooks.Open(file);

		/** �e�[�u���ꗗ���X�g�̃V�[�g���擾 */
	    var wsTables = dbSpecBook.Worksheets(CST_DB_SHIYOSYO_TBLLIST);

		/** �o�͗pBook�̍쐬 */
		var outTmpBook = ExcelApp.Workbooks.Add();

		/** �e�[�u����ꗗ�̃e�[�u�������ɏ�������  */
		for(var y=CST_DB_SHIYOSYO_TBLLIST_START_Y ; ; y++)
		{
			/** �Z���̏I�[���� */
			var value = wsTables.Cells(y, CST_DB_SHIYOSYO_TBLLIST_B_X);
			if(value != value +"")
			{
				break;
			}

			/** �e�[�u���������ł̃V�[�g�쐬 */
			outTmpBook.Worksheets.Add(
				outTmpBook.Worksheets(outTmpBook.Worksheets.Count)).Name
					= value;

			/** DB�d�l���̃e�[�u����`�V�[�g�I�u�W�F�N�g���擾 */
			var wsTbl = dbSpecBook.Worksheets(
				wsTables.Cells(y, CST_DB_SHIYOSYO_TBLLIST_R_X).Value);
			wlog("MakeTemplate_FromDBspecs() 2");

			/** �V�[�g���̑S�Z���̑����𕶎���ɂ��� */
			outTmpBook.Worksheets(outTmpBook.Worksheets.Count).Activate
			outTmpBook.Worksheets(outTmpBook.Worksheets.Count).Cells.Select
			wlog("MakeTemplate_FromDBspecs() 3");

			/** �e�e�[�u���̃J�����������ƃf�t�H���g�f�[�^���i�[ */
			for(var yy=CST_DB_SHIYOSYO_TBLS_CM_B_START_Y ; ; yy++)
			{
				/** �Z���̏I�[���� */
				var value2 = wsTbl.Cells(yy, CST_DB_SHIYOSYO_TBLS_CM_B_X);
				wlog("MakeTemplate_FromDBspecs() 4 > " + value2);
				if(value2 != value2 +"")
				{
				//	wlog("MakeTemplate_FromDBspecs() 4 > break;");
					break;
				}

				/** �J�������������擾���āA�o�̓V�[�g�̈�s�ڂɒ��� */
				outTmpBook.Worksheets(
					wsTables.Cells(y, 5).Value).Cells(1, yy - 7).Value
						= value2.Value.toUpperCase();
				wlog("MakeTemplate_FromDBspecs() 5 > ");
				/** �f�t�H���g�l��ݒu���� CST_DEF_DATA_CNT */
				for(var i=1 ; i < CST_DEF_DATA_CNT ; i++)
				{
					outTmpBook.Worksheets(
						wsTables.Cells(y, 5).Value).Cells(1 + i, yy - 7).Value
							= makeDefaultData(wsTbl.Cells(yy, 4).Value);
				//	wlog("MakeTemplate_FromDBspecs() 6 > " + yy);
				//	wlog("MakeTemplate_FromDBspecs() 6 > " + wsTbl.Cells(yy, 4).Value);
				}
			}
		}
		wlog("MakeTemplate_FromDBspecs() loop end");
	    /** book�̕ۑ� */
		outTmpBook.Close(true);
	} catch( e ) {
		alert( e );  // �o�O�̓��e���_�C�A���O�ŕ\������
	}
}

/****************************************************************************
 * �e���v���[�g�t�@�C���쐬
 * @param �f�[�^�^
 * @return tile �f�t�H���g�f�[�^
 ***************************************************************************/
function makeDefaultData(type)
{
	switch( true )
	{
	/** ������ */
	case /VARCHAR*/.test(type.toUpperCase()) : 
		return("A");
	/** ���l */
    case /NUMBER*/.test(type.toUpperCase()) : 
    	return("0");
	/** ���� */
    case /TIMESTAMP*/.test(type.toUpperCase()) :
    	return("2014-05-07 10:00:00");
	/** ���t */
    case /DATE*/.test(type.toUpperCase()) : 
    	return("2014-05-07 10:00:00");
	/** ��L�ȊO */
     default : 
    	return("0");
    }
}

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// �� �������火�́A���ʏ���(�_�C�A���O�֘A)
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/****************************************************************************
 * �t�@�C���I���_�C�A���O
 * @param filter �t�@�C���I���t�B���^
 * @param tile �_�C�A���O�^�C�g��
 * @return �擾�t�@�C���p�X
 ***************************************************************************/
function selectfile(filter,title)
{
    /** �t�@�C���I���_�C�A���O���J�� */
    var tmpFileName = ExcelApp.GetOpenFilename(filter,1,title,false);
	return(tmpFileName);
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

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// �� �������火�́A���ʏ���(���O�֘A)
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/****************************************************************************
 * ���O�o��
 * @param str �o�̓��b�Z�[�W
 ***************************************************************************/
function wlog(str)
{
	if(logfile!=null)
	{
		logfile.WriteLine(
			comDateFormat(new Date(),
			 "yyyy/MM/dd HH:mm:ss.fff") + " >> " + str);
	}
}

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// �� �������火�́A���ʏ���(���t����)
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/****************************************************************************
 * [�@�\]	�[���p�f�B���O���s���܂�
 * [����]	value	�Ώۂ̕�����
 * 			length	����
 * [�ߒl]	���ʕ�����
 ***************************************************************************/
function comPadZero(value, length){
	return new Array(length - ('' + value).length + 1).join('0') + value;
}

/****************************************************************************
 * [�@�\]	���t�I�u�W�F�N�g���當����ɕϊ����܂�
 * [����]	date	�Ώۂ̓��t�I�u�W�F�N�g
 * 			format	�t�H�[�}�b�g
 * [�ߒl]	�t�H�[�}�b�g��̕�����
 ***************************************************************************/
function comDateFormat(date, format)
{
	var result = format;
	var f;
	var rep;
	var yobi = new Array('��', '��', '��', '��', '��', '��', '�y');
	f = 'yyyy';
	if ( result.indexOf(f) > -1 ) {
		rep = date.getFullYear();
		result = result.replace(/yyyy/, rep);
	}
	f = 'MM';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getMonth() + 1, 2);
		result = result.replace(/MM/, rep);
	}
	f = 'ddd';
	if ( result.indexOf(f) > -1 ) {
		rep = yobi[date.getDay()];
		result = result.replace(/ddd/, rep);
	}
	f = 'dd';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getDate(), 2);
		result = result.replace(/dd/, rep);
	}
	f = 'HH';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getHours(), 2);
		result = result.replace(/HH/, rep);
	}
	f = 'mm';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getMinutes(), 2);
		result = result.replace(/mm/, rep);
	}
	f = 'ss';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getSeconds(), 2);
		result = result.replace(/ss/, rep);
	}
	f = 'fff';
	if ( result.indexOf(f) > -1 ) {
		rep = comPadZero(date.getMilliseconds(), 3);
		result = result.replace(/fff/, rep);
	}
	return result;

}
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
