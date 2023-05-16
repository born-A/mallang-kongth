import React, {useState} from 'react';
import '../../css/boardList.css';


const posts = [
    {
        id: 1,
        title: '잃어버린 강아지를 찾습니다',
        content: '첫 번째 게시물 내용입니다.',
        image: 'https://picsum.photos/id/237/200/200',
    },
    {
        id: 2,
        title: '제발 찾아주세요',
        content: '두 번째 게시물 내용입니다.',
        image: 'https://picsum.photos/id/837/200/200',
    },
    {
        id: 3,
        title: '경기대 후문 근처에서 목줄',
        content: '세 번째 게시물 내용입니다.',
        image: 'https://picsum.photos/id/1062/200/200',
    },
    {
        id: 4,
        title: '네 번째 게시물',
        content: '네 번째 게시물 내용입니다.',
        image: 'https://picsum.photos/id/2/200/200',
    }
];

function BoardList() {

    //const [posts, setPosts] = useState("");
    const [searchKeyword, setSearchKeyword] = useState("");

    const handleSearchChange = (event) => {
        setSearchKeyword(event.target.value);
    };
    /*const filteredPosts = posts.filter((post) =>
      post.title.includes(searchKeyword)
    );*/


    return (
        <div className="background">
            <div className="box">
                {/* 헤더부분 */}
                <div className="header">
                    <h1>말랑콩떡</h1>
                </div>

                {/* 게시판 선택 */}
                <div className="boardName">
                    <span className="missing">실종게시판</span>
                    <span>자유게시판</span>
                    <span>정보게시판</span>
                </div>

                {/* 검색 및 글쓰기 */}
                <div className="search-input">
                    <input
                        type="text"
                        value={searchKeyword}
                        onChange={handleSearchChange}
                        placeholder="🔎검색어를 입력하세요."
                    />
                    <button>검색</button>
                    <button>글 작성하기</button>
                    {/*<Link to="/write">글쓰기</Link>로 바꾸기기*/}
                </div>

                {/* 게시글 목록 */}
                <div className="post-list">
                    {posts.map((post) => (
                        <div className="post-item" key={post.id}>
                            <div className="post-image">
                                <img src={post.image} alt={post.title} />
                            </div>
                            <div className="post-content">
                                <p className="post-title">제목 : {post.title}</p>
                                <p className="post-text">내용 : {post.content}</p>
                            </div>
                        </div>
                    ))}
                </div>

            </div>
        </div>
    );
}

export default BoardList;