function validateForm() {
    const packerIdInput = document.getElementById('packer');

    const errorPackerId = document.getElementById('errorPacker');
    const errorsSummary = document.getElementById('errorsSummary');

    resetErrors([packerIdInput], [errorPackerId], errorsSummary);
    let valid = true;

    if (!checkRequired(packerIdInput.value) || packerIdInput.value<0) {
        valid = false;
        packerIdInput.classList.add("error-input");
        errorPackerId.innerText = "Pole jest wymagane";
    }
    else
        packerIdInput.classList.remove("error-input");

    if (!valid) {
        errorsSummary.innerText = "Formularz zawiera błędy";
    }
    return valid;
}