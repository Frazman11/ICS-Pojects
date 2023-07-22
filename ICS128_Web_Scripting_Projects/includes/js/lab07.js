/**
 * All jQuery and JS functionality depends on page being ready, to prevent activity before DOM and elements have loaded. 
 */
$(document).ready(function() {
  let Q1 = {
      Question: "Which 3 countries have the most disc golf courses per capita?",
      A1: "USA",
      A2: "Iceland",
      A3: "Estonia",
      A4: "Finland",
      A5: "Canada",
      A6: "Germany",
      HINT: "B, C, D",
      // Answer1: "Iceland"
      // Answer2: 
  };
  let Q2 = {
      Question: "Which professional player has earned the most in winnings",
      A1: "Ken Climo",
      A4: "David Feldberg",
      A3: "Ricky Wysocki",
      A2: "Paul McBeth",
      HINT: "B",
      Answer: "Paul McBeth"
  };
  let Q3 = {
      Question: "What is the most popular disc brand in North America",
      A1: "Discmania",
      A3: "Latitude 64",
      A4: "Discraft",
      A2: "Innova",
      HINT: "B",
      Answer: "Innova"
  };
  let Q4 = {
      Question: "Who holds the infamous 850ft Albatross at the Beaver State Fling?",
      A1: "Simon Lizotte",
      A2: "Niko Locastro",
      A3: "Eagle McMahon",
      A4: "Philo Braithwaite",
      HINT: "D",
      Answer: "Philo Braithwaite"
  };
  let Q5 = {
      Question: "Who is the youngest player to win the USDG Championship?",
      A1: "Eagle McMahon",
      A2: "Anthony Barela",
      A3: "Gannon Buhr",
      A4: "Toby Collis Handford",
      HINT: "C",
      Answer: "Gannon Buhr"
  };
  let MC = [Q2, Q3, Q4, Q5];
  /**
   * Generates the entire body of the quiz, starting with the welcome message. Creates elements for score to be displayed when generated via other methods.
   */
  function GenerateBody() {
      let body = $('#form');
      let welcome = `<h3>Welcome ${name}, Good Luck! </h3>`;
      body.append(welcome);
      let scoreMessage1 = `<p id="score1"><p>`
      body.append(scoreMessage1);
      let i = 0;
    /**
     * Dynamically Generates the MC questions and fades them in one by one to the quiz.
     * MS question generation is chained through this method.
     */
      function GenerateQuestion() {
          if (i < MC.length) {
              let question = $(`
          <div id="question-${i}" style="display: none;">
            <h2>${MC[i].Question}</h2>
            <div>
              <input name="Q${i}" type="radio" value="${MC[i].A1}">
              <label for="Q${i}">a) ${MC[i].A1}</label>
            </div>
            <div>
              <input name="Q${i}" type="radio" value="${MC[i].A2}">
              <label for="Q${i}">b) ${MC[i].A2}</label>
            </div>
            <div>
              <input name="Q${i}" type="radio" value="${MC[i].A3}">
              <label for="Q${i}">c) ${MC[i].A3}</label>
            </div>
            <div>
              <input name="Q${i}" type="radio" value="${MC[i].A4}">
              <label for="Q${i}">d) ${MC[i].A4}</label>
            </div>
            <div id="hintcontainer"> <p id="hint">[HINT] </p>
            <p id="answer">  = (${MC[i].HINT})</p> </div>
          </div>
        `);
              body.append(question);
              // Wrap the question element individually and fade it in
              question.hide().fadeIn(1000);
              i++;
              setTimeout(GenerateQuestion, 1000);
          } else {
              GenerateMSQuestion();
          }
      }
      GenerateQuestion();
  }
  /**
   * Generates the MS Question and adds it to the HTML with a fade.
   */
  function GenerateMSQuestion() {
      let body = $('#Card');
      let question = $(`<div id="questionMS">
      <h2>${Q1.Question}</h2>

      <div>
        <input name="Q1" type="checkbox" value="${Q1.A1}">
        <label for="Q1">a) ${Q1.A1}</label>
      </div>
      <div>
        <input name="Q1" type="checkbox" value="${Q1.A2}">
        <label for="Q1">b) ${Q1.A2}</label>
      </div>
      <div>
        <input name="Q1" type="checkbox" value="${Q1.A3}">
        <label for="Q1">c) ${Q1.A3}</label>
      </div>
      <div>
        <input name="Q1" type="checkbox" value="${Q1.A4}">
        <label for="Q1">d) ${Q1.A4}</label>
      </div>
      <div>
        <input name="Q1" type="checkbox" value="${Q1.A5}">
        <label for="Q1">e) ${Q1.A5}</label>
      </div>
      <div id="hintcontainer"> <p id="hint">[HINT] </p>
      <p id="answer">  = (${Q1.HINT})</p> </div><br>
      <button id="submit2">Submit</button>
    </div>`);
      body.append(question);
      // Wrap the question element individually and fade it in
      question.hide().fadeIn(1000);
  }
  /**
   * Event listener for begin button. Verifies a valid name has been entered, and begind quiz generation
   * and starts the timer.
   */
  let name;
  $('#submit').click(function(event) {
      event.preventDefault();
      //prevent automatic refresh and sending data to server
      let userInput = $('#name').val();
      const nameRegex = /^(?=.*[a-zA-Z])[a-zA-Z\s]+$/;
      if (nameRegex.test(userInput)) {
          // console.log(userInput);
          name = userInput;
          $('#intro').css('display', 'none');
          GenerateBody();
          timer();
      } else {
          $('#errorIntro').text("Please Enter a Valid Name");
      }
  });
  /**
   * Event Listener for quiz submit button. Stops the timerInterval, checks questions,
   * and then displays modal.
   */
  $(document).on('click', '#submit2', function(event) {
      event.preventDefault();
      clearInterval(timerInterval);
      $('#score1').text(`You Scored ${AddScores()} out of 5!`).hide().fadeIn(1000);

      if (checkQuestions()) {
          modal()
      }
  });
  /**
   * Determines if all questions have been checked, starting with each MC, then verifying that 3 MS boxes were checked.
   * @returns True or False - if all quesitons have been checked
   */
  function checkQuestions() {
      for (let i = 0; i < 4; i++) {
          if (!$('#question-' + i + ' input[type="radio"]').is(':checked')) {
              alert("Please answer all questions 1-4");
              return false;
          }
      }
      const checkedOptions = $('#questionMS input[type="checkbox"]:checked').length;
      if (checkedOptions !== 3) {
          alert("Please select exactly 3 answers for Question 5");
          return false;
      }
      return true;
  }
  /**
   * Hint fade in and out behaviour
   */
  $(document).on('mouseover', 'p#hint', function() {
      $(this).next('p#answer').fadeIn(1000)
  });
  $(document).on('mouseleave', 'p#hint', function() {
      $(this).next('p#answer').fadeOut(1000);
  });
  
  /**
   * Creates the timer object and sets countdown from 8 minutes.
   * updates the timer display every second.
   */
  let formattedTime;
  function timer() {
      let initialTime = Date.now();
      let endTime = initialTime + 480000;
      // console.log(initialTime);
      // console.log(endTime);
      // set an interval for updateTimer method to repeat
      timerInterval = setInterval(updateTimer, 1000);

      function updateTimer() {
          let currentTime = Date.now();
          //determine time left
          let timeDiff = endTime - currentTime;
          let sec = Math.floor((timeDiff / 1000) % 60);
          let min = Math.floor((timeDiff / 1000 / 60) % 60);
          formattedTime = `${min}:${sec}`;
          // console.log(formattedTime);
          $('#timerDisplay').text(`Time Remaining: ${formattedTime}`);
      }
  }
  /**
   * Determines the total score for all questions. Adds scores for MC first, then MS.
   * @returns score - total score rounded to nearest whole number.
   */
  function AddScores() {
      let score = 0;
      for (let i = 0; i < MC.length; i++) {
          // console.log($('input[type="radio"][name = "Q0"]:checked').val());
          if ($(`input[type="radio"][name = Q${i}]:checked`).val() == MC[i].Answer) {
              // alert('correct');
              score += 1;
          }
          // console.log(score);
      }
      // if($('input[type="checkbox"][name = "lang"]:checked').val() == 'php'){
      //     score += 0.5;
      // }
      //this wont work, it will only look at one correct answer.
      $('input[type="checkbox"][name = "Q1"]:checked').each(function() {
          if ($('input[type="checkbox"][name = "Q1"]:checked').val() == Q1.A2 || $(
                  'input[type="checkbox"][name = "Q1"]:checked').val() == Q1.A3 || $(
                  'input[type="checkbox"][name = "Q1"]:checked').val() == Q1.A4) {
              score += 1 / 3;
          }
      });
      score = Math.round(score);
      return score;
  }
  /**
   * Generates the text for within the modal, whether or not display should flash
   * and fades in the modal to view
   */
  function modal() {
      $('#modal').modal('show').css('display', 'none').fadeIn(3000);
      let results1 = '';
      let results2 = '';
      let timeMessage = `You finished in ${formattedTime} Seconds!`
      if (AddScores() === 5) {
          results1 = `${name}!`
          results2 = `You Scored ${AddScores()} out of 5. Perfect!`;
          $('#resultsName').text(results1);
          $('#resultsScore').text(results2);
      } else {
          let results = `Results for ${name}: Scored ${AddScores()} out of 5`;
          $('#resultsName').text(results);
      }
      $('#time').text(timeMessage);
      let flashes = 0;
      let flashInterval = setInterval(function() {
          if (AddScores() == 5) {
              $('#resultsScore').fadeOut(400).fadeIn(400);
              $('#resultsName').fadeOut(400).fadeIn(400);
              flashes++;
          }
          if (flashes === 11) {
              clearInterval(flashInterval)
          }
      }, 1000)
  }
  /**
   * Simple function to close the modal when close button is clicked
   */
  $(document).ready(function() {
      $("#modalClose").click(function() {
          $(".modal").modal('hide');
      });
  });
});
// Photo by <a href="https://unsplash.com/@ted_johnsson?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Ted Johnsson</a> on <a href="https://unsplash.com/photos/h2P_QmHvL-Y?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText">Unsplash</a>