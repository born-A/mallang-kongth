import React,{useState} from 'react';
import "../../css/boardWrite.css"
import {Link} from "react-router-dom";

function BoardWrite(){

    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [image, setImage] = useState(null);
    const [attachedFile, setAttachedFile] = useState(null);


    const handleTitleChange = (e) => {
        setTitle(e.target.value);
    };

    const handleContentChange = (e) => {
        setContent(e.target.value);
    };

    const handleFileChange = (event) => {
        const file = event.target.files[0];
        setAttachedFile(file);
    };
    const handleWriteConfirm = () => {
        if (title == '') {
            alert("제목을 입력해주세요!");
        }
        else if(content == ''){
            alert("내용을 입력해주세요!");
        } else {
            const isConfirmed = window.confirm(`작성을 완료하시겠습니까?`);
            if (isConfirmed) {
                // 추가하는 로직 작성
               //<Link to="/boardList" />
            } else {
                //
            }
        }
    };

    /*function handleImageDelete() {
      setImage(null);
  }*/


    /*const handleInputChange = (e) => {
      // 입력 값 처리 로직
    };*/

    return (
        <div className="background">
            <div className="box">
                {/* 헤더부분 */}
                <div className="header">
                    <h1>말랑콩떡</h1>
                    <Link to ="/mainPage"><span className="home">home</span></Link>
                </div>

                {/* 게시판 선택 */}
                <div className="boardName">
                    <span className="missing">실종게시판</span>
                    <span>자유게시판</span>
                    <span>정보게시판</span>
                </div>

                {/* 뒤로가기 및 작성완료료 */}
                <div className="boardHead">
                    <Link to ={"/boardList"} className="linkback"> &lt; 뒤로가기 </Link>
                    <button onClick={handleWriteConfirm}>작성완료</button> {/* 실제로는 링크로 연결해주기 */}
                </div>

                {/* 글 작성하기 */}
                <div className="boardWrite">
                    <input type="text" maxLength={20} className="Title" placeholder="제목을 입력하세요." value={title} onChange={handleTitleChange} />
                    <textarea className="Content" maxLength={300} placeholder="내용을 입력하세요." value={content} onChange={handleContentChange} />
                    {content.length}/300


                    <div className="imageBox">
                        <div className="small-box">
                            {attachedFile ? (
                                <img
                                    src={URL.createObjectURL(attachedFile)}
                                    alt="Uploaded File"
                                    style={{ maxWidth: '100px', maxHeight: '100px' }}
                                />
                            ) : (
                                <div
                                    style={{
                                        width: '100px',
                                        height: '100px',
                                        backgroundColor: '#eaeaea',
                                    }}
                                ></div>
                            )}
                        </div>

                        <input type="file" className="file-button" onChange={handleFileChange} />

                    </div>
                </div>

            </div>
        </div>
    )
}

export default BoardWrite;