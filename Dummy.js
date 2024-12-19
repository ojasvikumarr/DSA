import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
// import { switchTab } from "../../redux-toolkit/mainPage_option";
// import { a } from "react-router-dom";
// import a from 'next/a';
// import { Nava } from 'react-router-dom'
import styled from "styled-components";
// import { MdClose, MdMenu } from 'react-icons/md';
// import {gaEventTracker} from "./useAnalyticsEventTracker"
// 
import styles_css from "../styles/home.module.css"
import Link from "next/link";
import { useRouter } from "next/router";
// 
import Notifications from "./Notifications";
import UserMenu from "./UserMenu";
import Cart from "./CartComp";
import ChangePassword from "../overlay/changePassword";

const gaEventTracker = () => {
  console.log("GA Event Clicks");
};

const NavStyles = styled.nav`
  position: fixed;
  // position:sticky;
  z-index: 100;
  top: 0;
  left: 0;
  width: 100%;
  padding-bottom: 10px;
  background: var(--dark-bg);
  ul {
    margin: auto;
    width: 90%;
    width: -webkit-fill-available;
    text-align: right;
    li {
      display: inline-block;
      border-radius: 8px;
      transition: 0.3s ease background-color;
      &:hover {
        background-color: var(--deep-dark);
      }
    }
    a {
    }
    .active {
      color: var(--white);
    }
  }
  .mobile-menu-icon {
    position: absolute;
    right: 0rem;
    top: 1rem;
    width: 4rem;
    cursor: pointer;
    display: none;
    outline: none;
    * {
      pointer-events: none;
    }
  }
  .navItems .closeNavIcon {
    display: none;
  }

  .dtu {
    display: none;
  }

  .head_icon {
    display: flex;
    justify-content: space-between;
    display: none;
  }
  .left_options {
    margin: 20px 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
  }
  .left_options > div {
    display: flex;
    padding: 0 30px;
    box-sizing: border-box;
    justify-content: space-between;
    align-items: center;
    border-radius: 10px;
    gap: 10px;
    width: 90%;
    margin: 5px 0;
    text-align: center;
    font-size: 20px;
  }

  .left_options p {
    margin: 20px 0;
  }

  @media only screen and (max-width: 950px) {
    padding: 0;

    .head_icon {
      display: flex;
      justify-content: space-between;
      margin-top: 2rem;
      width: 100%;
    }

    .but_schedule {
      display: none;
    }

    .dtu {
      display: block;
      text-align: -webkit-left;
    }
    .hide-item {
      transform: translateY(calc(-100% - var(--top)));
    }
    .mobile-menu-icon {
      display: block;
    }
    .navItems {
      box-sizing: content-box;
      display: flex;
      flex-direction: column;
      justify-content: start;
      align-items: flex-start;
      // height: 50vh;
      --top: 1rem;
      color: white;
      background: linear-gradient(
        180deg,
        #3d3d3d 28.47%,
        #282828 90.45%,
        #282828 100%
      );
      border-radius: 30px 0px 0px 30px;
      transition: 0.3s ease transform;

      padding: 2rem;
      padding-top: 2rem;
      padding-bottom: 2rem;
      width: 90%;
      max-width: 300px;
      position: absolute;
      right: 0rem;
      top: 0;
      .closeNavIcon {
        display: flex;
        padding-left: 6px;
        /* margin: 0 0 0 auto; */
        cursor: pointer;
        * {
          pointer-events: none;
        }
      }
      li {
        display: block;
        margin-bottom: 1rem;
      }
    }
  }
`;

function Header() {
  const Router = useRouter();
  const [notif_open, toggle_notif] = useState(-1); // -1
  const [user_open, toggle_user] = useState(-1);
  const [cart_open, toggle_cart] = useState(-1);
  const [conf_msg, set_confMsg] = useState(false);

  const [userTab, setuserTab] = useState(false);
  const switchUser = () => {
    setuserTab(!userTab);
  }
  // const Dispatch = useDispatch();
  const [popupData, set_PopupData] = useState({
    toShow: false,
    data: {},
  });
  const cart = useSelector((i) => i.cart);
  // const Dispatch = useDispatch();
  const [showNav, setShowNav] = useState(false);
  return (
    <NavStyles>
      {popupData.toShow
        ? ChangePassword([popupData, set_PopupData], [conf_msg, set_confMsg])
        : undefined}
      <header className={styles_css.mobile_header} style={{ backdropFilter: "blur(5px)" }}>
        {/* <Link
            href="https://n0c.tech/",
              onClick={ gaEventTracker },
        > */}
        <img
          style={{
            margin: "5px 32px",
            width: "63.65px",
            // height: "41px",
            objectFit: "contain",
            paddingTop: "20px"
          }}
          alt="icons"
          destination="HomePage"
          src={"https://s3.ap-south-1.amazonaws.com/n0c.tech/public/images/logo.png"}
          className="header_logo"
        />
        <div
          style={{
            position: "absolute",
            right: "77.5px",
            top: "10px",
            // width: "31px",
            cursor: "pointer",
          }}
          onClick={() => {
            // toggle_user(user_open === 2 ? -1 : 2);
            switchUser();
          }}
          // onMouseOver={() => {
          //   toggle_user(2);
          // }}
          // onMouseOut={() => {
          //   toggle_user(-1);
          // }}
        >
          <img
            style={{ width: "44px" }}
            // src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/logout.jpg"
            src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/user_icon.png"
            alt=""
          />
        </div>
        <div
          style={{
            position: "absolute",
            right: "130px",
            top: "18px",
            width: "31px",
            cursor: "pointer",
          }}
          // onMouseOver={() => {
          //   toggle_notif(1);
          // }}
          onClick={() => {
            toggle_notif(notif_open === 1 ? -1 : 1);
          }}
          // onMouseOut={() => {
          //   toggle_notif(-1);
          // }}
        >
          <img
            style={{ width: "29px" }}
            src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/notif_bell.svg"
            alt=""
          />
        </div>

        {notif_open === 1 ?
          <Notifications
            // notif= {notif}
            toggle_cont_below={toggle_notif}
          /> : undefined
        }

        {user_open === 2 ?
          <UserMenu
            toggle_cont_below={toggle_user}
            popupData={popupData}
            set_PopupData={set_PopupData}
          /> : undefined
        }

        {cart_open === 3 ?
          <Cart
            toggle_cont_below={toggle_cart}
            cart={cart}
          /> : undefined
        }

        <div
          style={{
            position: "absolute",
            right: "150px",
            top: "17px",
            cursor: "pointer",
          }}
        // className={styles_css.top_right}
        >
          {/* {cart.data.length ? ( */}
          <div
            style={{
              position: "relative",
              height: "100%",
              // top: "20px",
              // right: "150px",
              display: "flex",
              alignItems: "center",
              cursor: "pointer",
              // width: "30px"
            }}
            // onMouseOver={() => {
            //   toggle_cart(3);
            // }}
            // onMouseOut={() => {
            //   toggle_cart(-1);
            // }}
            className={styles_css.cartIcon}
          >
            <div
              style={{
                position: "absolute",
                fontSize: "70%",
                top: "0",
                left: "60%",
                transform: "translate(-50%)",
              }}
            >
              {cart.data.length ? cart.data.length : ""}
            </div>
            <img
              style={{
                width: "33px",
              }}
              src="/cart.png" alt="" />
          </div>
          {/* ) : undefined} */}
        </div>
        <div className="mobile-right-header">
          <div
            className="mobile-menu-icon"
            onClick={() => setShowNav(!showNav)}
            role="button"
            // onKeyDown={() => setShowNav(!showNav)}
            // onMouseOut={() => setShowNav(!showNav)}
            tabIndex={0}
          >
            <img
              alt="icons"
              style={{ width: "32px", height: "25px", marginTop: "4px" }}
              src={"https://s3.ap-south-1.amazonaws.com/n0c.tech/public/images/menu.png"}
            ></img>
          </div>
          <div
            className="mobile-menu-icon"
            onClick={() => setShowNav(!showNav)}
            role="button"
            onKeyDown={() => setShowNav(!showNav)}
            tabIndex={0}
          >
            <img
              alt="icons"
              style={{
                width: "32px",
                height: "25px",
                marginTop: "4px"
              }}
              src={"https://s3.ap-south-1.amazonaws.com/n0c.tech/public/images/menu.png"}
            ></img>
          </div>
        </div>
        <div
          className="mobile-menu-icon"
          onClick={() => setShowNav(!showNav)}
          role="button"
          onKeyDown={() => setShowNav(!showNav)}
          // onMouseOut={() => setShowNav(false)}
          tabIndex={0}
        >
          <img
            alt="icons"
            style={{ width: "32px", height: "25px", marginTop: "4px" }}
            src={"https://s3.ap-south-1.amazonaws.com/n0c.tech/public/images/menu.png"}
          ></img>
        </div>
        <ul onMouseOut={() => setShowNav(false)} className={!showNav ? "navItems hide-item" : "navItems"}>
          <div
            className="closeNavIcon"
            onClick={() => setShowNav(!showNav)}
            role="button"
            onKeyDown={() => setShowNav(!showNav)}
            tabIndex={0}
          >
            <img
              alt="icons"
              style={{ width: "20px", height: "20px", marginTop: "4px" }}
              src={"https://s3.ap-south-1.amazonaws.com/n0c.tech/public/images/close.png"}
            ></img>
          </div>
          <button
            style={{
              // width: "40px",
              cursor: "pointer",
              position: "absolute",
              right: "25px",
              top: "30px",
              color: "white",
              fontWeight: "700"
            }}
            onClick={() => {
              window.localStorage.removeItem("authToken");
              Router.push("./sign");
            }}
          >Logout</button>

          <div className="left_options">
            <div
              onClick={() => {
                setShowNav(false);
                Router.push("./");
              }}
            >
              <img src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/home.svg" alt="" />
              <p>Home</p>
            </div>
            <div
              onClick={() => {
                setShowNav(false);
                Router.push("./analytics");
              }}
            >
              <img src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/analytics.svg" alt="" />
              <p>Analytics</p>
            </div>
            <div
              onClick={() => {
                setShowNav(false);
                Router.push("./organisation");
              }}
            >
              <img src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/organisation.svg" alt="" />
              <p>Organisation</p>
            </div>
            <div
              onClick={() => {
                setShowNav(false);
                Router.push("./purchase");
              }}
            >
              <img
                style={{
                  width: "29px"
                }}
                src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/shopping-cart-white-logo.png" alt="" />
              <p>Purchase</p>
            </div>
            <div
              onClick={() => {
                setShowNav(false);
                Router.push("./team");
              }}
            >
              <img src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/team.svg" alt="" />
              <p>Team</p>
            </div>
            <div
              onClick={() => {
                setShowNav(false);
                Router.push("./guide");
              }}
            >
              <img src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/guide.svg" alt="" />
              <p>Guide</p>
            </div>
            <div
              onClick={() => {
                setShowNav(true);
                Router.push("./settings");
              }}
            >
              <img src="https://s3.ap-south-1.amazonaws.com/n0c.tech/public/assets/settings.svg" alt="" />
              <p>Settings</p>
            </div>
          </div>
        </ul>
      </header>
    </NavStyles>
  );
}
export default Header;
