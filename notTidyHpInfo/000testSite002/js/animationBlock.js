/**
 * 透明にしながら折りたたむ
 */
$( function() {
//  $( '#animate-title' ) . click( function() {
//    $( '#animate-block' ) . animate( { height: 'toggle', opacity: 'toggle' }, 'slow' );
//  });
  $( "[id^=animate-title]" ).click( function() {
	//alert('#animate-block' + $(this).attr("id").slice(-2));
    $('#animate-block' + $(this).attr("id").slice(-2)).animate( { height: 'toggle', opacity: 'toggle' }, 'slow' );
    //alert($('#animate-block' + $(this).attr("id").slice(-2)).is(':visible'));
  });
});
