function submitButton(linkType) {

    if (document.all.actForm.functionName != null) {
		document.all.actForm.functionName.value = linkType;
	}
	document.all.actForm.submit();
	window.dialogArguments.submitButton('');
     this.close();
}