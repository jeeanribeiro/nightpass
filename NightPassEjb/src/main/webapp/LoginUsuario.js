const loginInput = document.querySelector('#login');
$('#login').keypress(function(event) {
  if (loginInput.value.match(/^[0-9]*$/) && isFinite(event.key)) {
    $('#login').mask('000.000.000-00', {reverse: true});
    $('#login').attr('type', 'tel');
  } else if (!isFinite(event.key) && event.key !== 'Enter') {
    $('#login').unmask();
    $('#login').attr('maxlength', 320);
    $('#login').attr('type', 'email');
  }
});

document.getElementById('signIn').onclick = function(e) {
  e.preventDefault();
  window.location.href = 'file:///C:/Users/jefff/nightpass/main.html'
};
