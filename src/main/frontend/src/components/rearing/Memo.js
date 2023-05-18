import React, { useState } from 'react';
import './Memo.css';

function MemoForm({ onMemoSubmit }) {
    const [memo, setMemo] = useState('');

    const handleSubmit = () => {
        onMemoSubmit(memo);
    };

    return (
        <div className="memo-form-container">
            <div className="memo-form-title">
                <h1>메모 작성</h1>
            </div>
            <form onSubmit={handleSubmit}>
                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="memo" className="form-label-memo">메모</label>
                        <textarea
                            id="memo"
                            rows="5"
                            value={memo}
                            onChange={(event) => setMemo(event.target.value)}
                        />
                    </div>
                </div>

                <div className="submit-button">
                    <button type="submit" className="form-button-submit">
                        작성 완료
                    </button>
                </div>
            </form>
        </div>
    );
}

export default MemoForm;
