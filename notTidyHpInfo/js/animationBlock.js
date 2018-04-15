/**
 * 透明にしながら折りたたむ
 */
jQuery( function() {
    jQuery( '#animate-title' ) . click( function() {
        jQuery( '#animate-block' ) . animate( { height: 'toggle', opacity: 'toggle' }, 'slow' );
    } );
} );