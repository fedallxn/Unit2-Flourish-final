//this is my pop-up message that will appear after a user wants to delete a plant, to "confirm" they actually want to remove it
function ConfirmModal({message, confirm, cancel}) {
    return (
        <div className="modal-overlay">
            <div className="modal-message">
                <p>{message}</p>
                <div className="modal-buttons">
                    <button onClick={confirm}>Yes, please!</button>
                    <button onClick={cancel}>Actually...</button>
                </div>
            </div>
        </div>
    )
}

export default ConfirmModal;